// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import javax.crypto.SecretKey;
// import java.util.Date;
// import java.util.Map;

// public class JwtUtil {

//     private final SecretKey key;
//     private final long expiration;

// // REPLACE your current constructor with this
//     public JwtUtil(String secret, long expiration) {
//         this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
//         this.expiration = expiration;
//     }


//     public JwtUtil() {
//         this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//         this.expiration = 3600000; // default 1 hour
//     }


//     public String generateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(key)
//                 .compact();
//     }

//     public String generateTokenForUser(com.example.demo.entity.UserAccount user) {
//         Map<String,Object> claims = Map.of(
//                 "userId", user.getId(),
//                 "email", user.getEmail(),
//                 "role", user.getRole()
//         );
//         return generateToken(claims, user.getEmail());
//     }

//     public String extractUsername(String token) {
//         return parseToken(token).getSubject();
//     }

//     public Long extractUserId(String token) {
//         Object val = parseToken(token).get("userId");
//         return Long.valueOf(String.valueOf(val));
//     }

//     public String extractRole(String token) {
//         return (String) parseToken(token).get("role");
//     }

//     public boolean isTokenValid(String token, String username) {
//         return extractUsername(token).equals(username);
//     }

//     // public Claims parseToken(String token) {
//     //     return Jwts.parserBuilder()
//     //             .setSigningKey(key)
//     //             .build()
//     //             .parseClaimsJws(token)
//     //             .getBody();
//     // }
//         public Claims extractAllClaims(String token) {
//             return Jwts.parserBuilder()
//                     .setSigningKey(secretKey)
//                     .build()
//                     .parseClaimsJws(token)
//                     .getBody();
//         }


// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final SecretKey key;
    private final long expiration;

    public JwtUtil(
            @Value("${jwt.secret:test-secret-key-12345678901234567890}") String secret,
            @Value("${jwt.expiration:3600000}") long expiration) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expiration = expiration;
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(com.example.demo.entity.UserAccount user) {
        Map<String, Object> claims = Map.of(
                "userId", user.getId(),
                "email", user.getEmail(),
                "role", user.getRole()
        );
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Long extractUserId(String token) {
        return Long.valueOf(extractAllClaims(token).get("userId").toString());
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role").toString();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    // 🔥 Required by test cases
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 🔥 Required by test cases
    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
