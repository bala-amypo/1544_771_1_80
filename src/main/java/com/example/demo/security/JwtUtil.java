package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private SecretKey key;
    private static final long EXPIRATION_MS = 1000 * 60 * 60; // 1 hour

    /* ================= INIT ================= */

    // Required by tests
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    private SecretKey getKey() {
        if (key == null) {
            initKey();
        }
        return key;
    }

    /* ================= TOKEN GENERATION ================= */

    // Used by UserAccountController
    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("email", user.getEmail());

        return generateToken(claims, user.getEmail());
    }

    // Used by tests
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getKey())
                .compact();
    }

    /* ================= TOKEN PARSING ================= */

    // Used by filter
    public String extractEmail(String token) {
        return extractUsername(token);
    }

    // Used by tests & filter
    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    // Used by tests
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /* ================= VALIDATION ================= */

    // Used by JwtAuthenticationFilter
    public boolean isTokenValid(String token, String username) {
        try {
            String extractedUsername = extractUsername(token);
            return extractedUsername.equals(username) && !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
