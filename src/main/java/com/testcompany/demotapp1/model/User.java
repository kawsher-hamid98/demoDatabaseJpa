package com.testcompany.demotapp1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Customer")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id;

    @NotNull(message = "Name should not be null")
    @Size(min = 2, max = 12, message = "Size should be between 2 and 12 characters")
    public String name;

    @Column(unique = true)
    @Email
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email must include a domain with a TLD (like .com, .org, etc.)"
    )
    public String email;


    @Column(name = "uName")
    public String userName;

    public String password;

    public User() {}

    public User(Long id, String name, String email, String userName, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}