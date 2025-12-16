package com.example.academic.model;

import java.time.LocalDateTime;

public class UserAccount {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private  String role;
    private  String department;
    private  LocalDateTime createdAt;
    public UserAccount(String fullName, String email, String password, String role, String department,
            LocalDateTime createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public String getDepartment() {
        return department;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



}
