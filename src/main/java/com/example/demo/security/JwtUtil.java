package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtUtil {

    public void initKey() {
        // dummy for test
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return "dummy-token";
    }

    public String parseToken(String token) {
        return "test@example.com";
    }
}
