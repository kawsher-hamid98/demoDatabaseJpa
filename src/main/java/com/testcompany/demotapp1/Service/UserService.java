package com.testcompany.demotapp1.Service;

import com.testcompany.demotapp1.exception.EmailNotValidException;
import com.testcompany.demotapp1.exception.UserNotFoundException;
import com.testcompany.demotapp1.exception.UserValidationException;
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

    public User save(User user) {
        if (user.name == null || user.password == null) {
            throw new UserValidationException("Username or email or password is null");
        }

        if (!user.email.endsWith(".com")) {
            throw new EmailNotValidException("Email doesn't end with .com");
        }

        return userRepository.save(user);
    }

    public User findSingleUser(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("User not found", 204);
        }

        log.info("User found successfully, {}", user);
        return user;
    }
}
