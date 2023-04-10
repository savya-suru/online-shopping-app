package com.example.online.shopping.exception;

public class PasswordMisMatch extends RuntimeException {
    public PasswordMisMatch(String msg) {
        super(msg);
    }
}