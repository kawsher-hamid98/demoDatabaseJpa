package com.testcompany.demotapp1.Service;

import com.testcompany.demotapp1.model.User;
import com.testcompany.demotapp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
