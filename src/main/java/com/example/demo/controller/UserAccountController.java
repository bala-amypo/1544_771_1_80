package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    // POST /auth/register
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userAccountService.register(user);
    }

    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    
    @GetMapping("/users/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUser(id);
    }
}
