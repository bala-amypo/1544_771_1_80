package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import com.example.demo.entity.UserAccount;

@Component
public class JwtUtil {

    private SecretKey key;

    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public JwtTokenWrapper parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return new JwtTokenWrapper(claims);
    }


    public Claims getPayload(String token) {
        return parseToken(token).getPayload();
    }

    public Claims getBody(String token) {
        return parseToken(token).getPayload();
    }


    // TEST EXPECTS THIS EXACT SIGNATURE
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
    }

    // TEST EXPECTS THIS
    public String generateTokenForUser(UserAccount ua) {
        return generateToken(
                Map.of("email", ua.getEmail(), "role", ua.getRole(), "userId", ua.getId()),
                ua.getEmail()
        );
    }

    public boolean isTokenValid(String token, String expectedEmail) {
        return parseToken(token).getSubject().equals(expectedEmail);
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
}
