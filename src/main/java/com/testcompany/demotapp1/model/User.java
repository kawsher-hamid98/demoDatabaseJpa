package com.testcompany.demotapp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id;
    public String name;
    @Column(unique = true)
    public String email;
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


//Super key null, name_email, id_name_email, id, email
//candidate key
//Primary Key
//Composite key
//Alternate key
//surrogate key