package com.example.online.shopping.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        System.out.println("Get password working from loginrequest");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
