package com.testcompany.demotapp1.controller;

import com.testcompany.demotapp1.Service.UserService;
import com.testcompany.demotapp1.model.User;
import jakarta.validation.Valid;
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
    public User saveUser(@Valid @RequestBody User user) {
        log.info("user object: {}", user);

        return userService.save(user);
    }

    @GetMapping("/find")
    public User findSingleUser(@RequestParam String email) {
        return userService.findSingleUser(email);
    }
}
