package com.testcompany.demotapp1.exception;

public class UserNotFoundException extends RuntimeException {
    int code;
    public UserNotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}
