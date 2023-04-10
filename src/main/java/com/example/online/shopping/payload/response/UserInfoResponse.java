package com.example.online.shopping.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {

    private String id;
    private String username;
    private String email;
    private List<String> roles;
}
