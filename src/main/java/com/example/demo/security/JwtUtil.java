package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private SecretKey key;
    private final long expirationMillis = 1000 * 60 * 60; // 1 hour

    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        return generateToken(claims, user.getEmail());
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).get("role");
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    public boolean isTokenValid(String token, String username) {
        try {
            return extractUsername(token).equals(username);
        } catch (Exception ex) {
            return false;
        }
    }
}
