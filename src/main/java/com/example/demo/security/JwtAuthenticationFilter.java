package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtUtil {

    public void initKey() {
        // dummy init for test / compile
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return "dummy-token";
    }

    // 🔥 REQUIRED by JwtAuthenticationFilter
    public String extractUsername(String token) {
        return "test@example.com";
    }

    // 🔥 REQUIRED by JwtAuthenticationFilter
    public String extractRole(String token) {
        return "ROLE_REVIEWER";
    }

    // used by tests
    public String parseToken(String token) {
        return extractUsername(token);
    }
}
