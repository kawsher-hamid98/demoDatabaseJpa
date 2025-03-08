package com.testcompany.demotapp1.controller;

import com.testcompany.demotapp1.Service.UserService;
import com.testcompany.demotapp1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/find")
    public void findSingleUser(String email) {
        try {
            userService.findSingleUser(email);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
