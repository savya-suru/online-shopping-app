package com.example.online.shopping.service;

import com.example.online.shopping.payload.LoginRequest;
import com.example.online.shopping.payload.SignupRequest;
import com.example.online.shopping.payload.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> register(SignupRequest signupRequest);

    ResponseEntity<?> login(LoginRequest loginRequest);


}
