package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.validation.ValidationException;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccount register(UserAccount user) {
        if (userAccountRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount getUser(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
