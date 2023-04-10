package com.example.online.shopping.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class SignupRequest {

    @NotBlank(message = "Signup first Name not be null")
    private String firstName;
    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    //Chulbul(cpass, conNum)
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String contactNumber;

}
