package com.osiki.BookApplication.dto;

import com.osiki.BookApplication.enums.Gender;
import com.osiki.BookApplication.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min = 2, max = 125, message = "name must be at least 2 characters")
    @NotBlank(message = "firstname must not be blank")
    private String firstname;

    @Size(min = 2, max = 125, message = "name must be at least 2 characters")
    @NotBlank(message = "lastname must not be blank")
    private String lastname;

    @Size(min = 5, max = 50)
    @Email(message = "E-mail must be valid")
    @NotBlank(message = "E-mail required")
    private String email;

    @Size(min = 6, max = 65, message = "password must be at least 6 characters")
    @NotBlank(message = "password must not be blank")
    private String password;

    @Size(min = 6, max = 65, message = "confirm password must be at least 6 characters")
    @NotBlank(message = "confirm password must not be blank")
    private String confirmPassword;

    private Role role;

    private Gender gender;
}
