package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.UserAccountService;
//import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserAccountController {

    private final UserAccountService userAccountService;
    //private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public UserAccountController(UserAccountService userAccountService,
                                 JwtUtil jwtUtil,
                                 PasswordEncoder passwordEncoder) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    
    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount();
        user.setFullName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // raw password
        user.setRole(request.getRole());
        user.setDepartment(request.getDepartment());

        return userAccountService.register(user);
    }

    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        UserAccount user = userAccountService.findByEmail(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ValidationException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("userId", user.getId());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        return response;
    }

   
    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    
    @GetMapping("/users/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUser(id);
    }
}
