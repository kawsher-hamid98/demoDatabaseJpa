package com.testcompany.demotapp1.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UserGlobalExceptionHandler {
    @ExceptionHandler({UserValidationException.class, EmailNotValidException.class})
    public void userValidationException(Exception e) {
        log.error(e.getClass().getName());
        log.error(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public void userValidationException(UserNotFoundException e) {
        log.error("Exception: {}: Code: {}", e.getMessage(), e.code);
    }
}
