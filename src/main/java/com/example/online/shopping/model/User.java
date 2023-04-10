package com.example.online.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @NotNull(message = "User's first name must not be null")
    private String firstName;

    @NotNull(message = "The above field must not be blank.")
    private String lastName;


    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String password;
    @NotNull

    @Transient
    private String confirmPassword;

    @NotNull
    private String contactNumber;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User(String firstName, String lastName, String email, String username, String password,String confirmPassword, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.contactNumber = contactNumber;
    }




}
