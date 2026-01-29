package Alain.Alain.sDemo.controllers;

import Alain.Alain.sDemo.models.User;
import Alain.Alain.sDemo.repository.UserRepository;
import Alain.Alain.sDemo.service.UserService;
import Alain.Alain.sDemo.utills.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {


    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    //    Register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");
        password = passwordEncoder.encode(password);

        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with same Email Exists");
        }

        userService.createUser(User.builder().email(email).password(password).build());
        return ResponseEntity.status(HttpStatus.CREATED).body("User created Successfully");
    }


    //    Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> body) {

        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid Credentials"));

        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid Credentials"));

        String token = jwtUtil.generateToken(email);

        return ResponseEntity.ok(Map.of("token", token));
    }
}