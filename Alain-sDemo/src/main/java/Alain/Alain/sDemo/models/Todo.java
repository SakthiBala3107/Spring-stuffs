package Alain.Alain.sDemo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
//@Data

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Remove @NotNull - @NotBlank already covers it
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 2, max = 50, message = "Title must be 2-50 characters")
            @Schema(name = "title", example = "Crack Meta")
    String title;

    @NotBlank(message = "Description cannot be empty")
    String description;

    @Column(nullable = false)
    private Boolean isCompleted = false;

    // Email
    @NotBlank(message = "Email field cannot be blank")  // Use @NotBlank instead of @NotNull
    @Email(message = "Email must be valid")
    @Column(unique = true)
    private String email;

    // Password
    @NotBlank(message = "Password field must not be empty")  // Use @NotBlank
    @Size(min = 8, max = 100, message = "Password must be 8-100 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!*]).{8,}$",
            message = "Password must contain: uppercase, lowercase, number, and special character"
    )
    private String password;

    // Phone
    @NotBlank(message = "Phone number cannot be empty")  // Use @NotBlank
    @Pattern(
            regexp = "^\\d{10}$",
            message = "Phone must be exactly 10 digits"
    )
    private String phone;
}