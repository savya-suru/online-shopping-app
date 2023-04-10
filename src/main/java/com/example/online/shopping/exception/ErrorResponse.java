package com.example.online.shopping.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int statusCode,String message)
    {

        super();

        this.statusCode = statusCode;
        this.message = message;
    }

}
