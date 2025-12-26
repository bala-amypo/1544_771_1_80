package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirationMillis = 1000 * 60 * 60; // 1 hour

    public JwtUtil() {
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /* ================= TOKEN GENERATION ================= */

    public String generateTokenForUser(UserAccount user) {
        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(secretKey)
                .compact();
    }

    /* ================= TOKEN PARSING ================= */

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }

    // ✅ THIS METHOD FIXES YOUR ERROR
    public Claims getPayload(String token) {
        return parseToken(token).getBody();
    }
}
