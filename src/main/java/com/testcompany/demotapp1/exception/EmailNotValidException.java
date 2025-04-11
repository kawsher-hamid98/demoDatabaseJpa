package com.testcompany.demotapp1.exception;

public class EmailNotValidException extends RuntimeException{
    public EmailNotValidException(String message){
        super(message);
    }
}
