package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;

    public UserAccountController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setDepartment(request.getDepartment());
        user.setRole(request.getRole());

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        UserAccount user = userService.findByEmail(request.getEmail());

        String token = jwtUtil.generateTokenForUser(user);

        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
