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
    public User saveUser(@RequestBody User user) {
        try {
            userService.save(user);
            log.info("User saved successfully");

            return user;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return null;
    }

    @GetMapping("/find")
    public User findSingleUser(@RequestParam String email, @RequestParam(name = "userName") String uName) {
        log.info("email: {}", email);
        log.info("uName: {}", uName);

        try {
            return userService.findSingleUser(email);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
