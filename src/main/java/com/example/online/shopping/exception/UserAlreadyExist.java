package com.example.online.shopping.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String s) {
        super(s);
    }
}
