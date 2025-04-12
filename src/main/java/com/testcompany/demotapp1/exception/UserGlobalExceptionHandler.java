package com.testcompany.demotapp1.exception;

import com.testcompany.demotapp1.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> userArgValidationException(MethodArgumentNotValidException e) {
        List<String> res = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(res);
    }
}
