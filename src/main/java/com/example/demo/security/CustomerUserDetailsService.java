package com.example.demo.security;

import org.springframework.security.core.CustomerDetailsService.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements CustomerDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return User.withUsername(username)
                .password("password")
                .roles("USER")
                .build();
    }
}
