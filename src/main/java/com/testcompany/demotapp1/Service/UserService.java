package com.testcompany.demotapp1.Service;

import com.testcompany.demotapp1.exception.UserNotFoundException;
import com.testcompany.demotapp1.model.Product;
import com.testcompany.demotapp1.model.User;
import com.testcompany.demotapp1.repository.ProductRepository;
import com.testcompany.demotapp1.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public User save(User user) {
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

    public List<User> findAllUser() {
        List<User> userList = userRepository.findAll();
        log.info("userList: {}", userList);

        return userList;
    }

    @Transactional
    public void saveUserWithProduct(User user) {
        userRepository.save(user);
        productRepository.save(new Product("Rice", 0));
    }
}
