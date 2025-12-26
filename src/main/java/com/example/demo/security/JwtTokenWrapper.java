package com.example.demo.security;

import io.jsonwebtoken.Claims;

public class JwtTokenWrapper {
    private final Claims payload;

    public JwtTokenWrapper(Claims payload) {
        this.payload = payload;
    }

    public Claims getPayload() {
        return payload;
    }

    public Claims getBody() {
        return payload;
    }
}
