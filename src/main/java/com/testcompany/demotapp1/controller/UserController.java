package com.testcompany.demotapp1.controller;

import com.testcompany.demotapp1.Service.UserService;
import com.testcompany.demotapp1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        try {
            userService.save(user);
            log.info("User saved successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
