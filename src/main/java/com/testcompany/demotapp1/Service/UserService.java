package com.testcompany.demotapp1.Service;

import com.testcompany.demotapp1.model.User;
import com.testcompany.demotapp1.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        if (user.name == null || user.email == null || user.password == null) {
            throw new IllegalArgumentException("Username or email or password is null");
        }

        userRepository.save(user);
    }

    public User findSingleUser(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        log.info("User found successfully, {}", user);
        return user;
    }
}
