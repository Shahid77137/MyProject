package com.masai.otms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adminId;

    @NotNull(message = "Address Cannot be empty or blank or null")
    @NotEmpty(message = "Address Cannot be empty or blank or null")
    @NotBlank(message = "Address Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Address should be 3 to 20 letters")
    private String adminName;

    @NotNull(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least 8 characters long, and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;

    @NotNull(message = "Email Cannot be empty or blank or null")
    @NotEmpty(message = "Email Cannot be empty or blank or null")
    @NotBlank(message = "Email Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Email should be 3 to 20 letters")
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email Format: abc1234@domain.com")
    private String email;

    @NotNull(message = "Phone Number Cannot be empty or blank or null")
    @NotEmpty(message = "Phone Number Cannot be empty or blank or null")
    @NotBlank(message = "Phone Number Cannot be empty or blank or null")
    @Size(min = 13, max = 13, message = "Country Code(+91) + 10 digit Phone Number ")
    @Pattern(regexp = "^\\+91[1-9]\\d{9}$", message = "Format: +911234567809")
    private String phoneNumber;
}
