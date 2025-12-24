package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    public UserAccount save(UserAccount user) {
        return repository.save(user);
    }
}
