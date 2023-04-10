package com.example.online.shopping.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String msg){
        super(msg);
    }
}
