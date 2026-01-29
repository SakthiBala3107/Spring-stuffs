package Alain.Alain.sDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fakeController {
@GetMapping("/hello")
    String sayHello(){
        return "Yo you are here in Java backedn";

    }
}
