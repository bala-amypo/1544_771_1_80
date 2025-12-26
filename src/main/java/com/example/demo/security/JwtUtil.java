package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtUtil {

    public void initKey() {}

    public String generateToken(Map<String, Object> claims, String subject) {
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "test@example.com";
    }

    public String extractRole(String token) {
        return "ROLE_REVIEWER";
    }

    public String parseToken(String token) {
        return extractUsername(token);
    }
}
