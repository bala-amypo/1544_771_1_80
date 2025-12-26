package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateTokenForUser(UserAccount user) {
        return "dummy-jwt-token";
    }

    public String extractUserId(String token) {
        return "1";
    }

    public boolean isTokenValid(String token, String username) {
        return true;
    }

    public String getPayload() {
        return "payload";
    }
}
