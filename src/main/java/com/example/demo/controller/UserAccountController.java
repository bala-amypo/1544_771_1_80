// package com.example.demo.controller;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.ApiResponse;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/users")
// public class UserAccountController {

//     @Autowired
//     private UserAccountService userAccountService;

//     @Autowired
//     private JwtUtil jwtUtil;

//     @PostMapping("/register")
//     public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest request) {
//         // Map DTO to entity
//         UserAccount user = new UserAccount();
//         user.setFullName(request.getFullName());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         user.setRole(request.getRole());
//         user.setDepartment(request.getDepartment());

//         // Save user
//         UserAccount savedUser = userAccountService.registerUser(user);

//         // Generate JWT
//         String token = jwtUtil.generateToken(savedUser);

//         // Build response
//         AuthResponse response = new AuthResponse(token, savedUser.getEmail(), savedUser.getRole());
//         return ResponseEntity.ok(response);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest request) {
//         UserAccount user = userAccountService.authenticate(request.getEmail(), request.getPassword());
//         String token = jwtUtil.generateToken(user);
//         AuthResponse response = new AuthResponse(token, user.getEmail(), user.getRole());
//         return ResponseEntity.ok(response);
//     }

//     @GetMapping("/status")
//     public ResponseEntity<ApiResponse> status() {
//         return ResponseEntity.ok(new ApiResponse(true, "Service is running"));
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount register(UserAccount user) {

        if (userAccountRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already in use");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (user.getRole() == null) {
            user.setRole("REVIEWER");
        }
        
        user.setCreatedAt(LocalDateTime.now());
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount getUser(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public UserAccount authenticate(String email, String password) {
        return userAccountRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new ValidationException("Invalid credentials"));
    }
}
