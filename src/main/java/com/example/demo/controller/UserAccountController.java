package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final JwtUtil jwtUtil;

    // ✅ Constructor injection (IMPORTANT)
    public UserAccountController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // example usage
    // String token = jwtUtil.generateToken(email);
}
