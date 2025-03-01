package com.testcompany.demotapp1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class User {
    @Id
    public int id;
    public String name;
    @Column(unique = true)
    public String email;
    public String userName;
    public String password;

    public User() {}

    public User(int id, String name, String email, String userName, String password) {
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


//protected
//private
//default
//public

