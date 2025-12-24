package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    public UserAccount() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // REQUIRED BY TEST
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void prePersist() { }   // REQUIRED BY TEST
}
