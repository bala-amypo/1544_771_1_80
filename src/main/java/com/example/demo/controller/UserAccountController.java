package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest request) {

        // Create user entity
        UserAccount user = new UserAccount();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password()); // make sure service hashes password
        user.setRole(request.role());
        user.setBranch(request.branch());

        // Save user
        userAccountService.registerUser(user);

        // Generate JWT
        String token = jwtUtil.generateTokenForUser(user);

        // Return response
        AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest request) {

        // Authenticate and fetch user
        UserAccount user = userAccountService.authenticate(request.email(), request.password());

        // Generate JWT
        String token = jwtUtil.generateTokenForUser(user);

        // Return response
        AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }
}
