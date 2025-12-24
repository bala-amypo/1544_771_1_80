package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Generate dummy token
    public String generateToken(String username) {
        return "jwt-token-" + username;
    }

    // Extract username from dummy token
    public String extractUsername(String token) {
        if (token == null) {
            return null;
        }

        if (token.startsWith("jwt-token-")) {
            return token.substring(10);
        }

        return null;
    }

    // Validate token (dummy validation)
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername != null && extractedUsername.equals(username);
    }
}
