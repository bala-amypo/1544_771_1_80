package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccount registerUser(UserAccount user) {
        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserAccount authenticate(String email, String password) {
        UserAccount user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    public UserAccount register(UserAccount user) {
    if (userAccountRepository.existsByEmail(user.getEmail())) {
        throw new ValidationException("Email already in use");
    }
    if (user.getPassword() != null && user.getPassword().length() < 8) {
        throw new ValidationException("Password must be at least 8 characters");
    }
    if (user.getRole() == null) {
        user.setRole("REVIEWER");
    }
    return userAccountRepository.save(user);
}

    public UserAccount getUser(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
