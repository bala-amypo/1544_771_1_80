package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BranchProfile createBranch(BranchProfile branch) {
        return repository.save(branch);
    }

    @Override
    public BranchProfile updateBranchStatus(Long id, boolean active) {
        Optional<BranchProfile> optionalBranch = repository.findById(id);
        if (optionalBranch.isPresent()) {
            BranchProfile branch = optionalBranch.get();
            branch.setActive(active);
            return repository.save(branch);
        }
        return null;
    }

    @Override
    public BranchProfile getBranchById(Long id) {
        Optional<BranchProfile> optionalBranch = repository.findById(id);
        return optionalBranch.orElse(null);
    }

    @Override
    public List<BranchProfile> getAllBranches() {
        return repository.findAll();
    }

    @Override
    public BranchProfile findByBranchCode(String branchCode) {
        Optional<BranchProfile> optionalBranch = repository.findByBranchCode(branchCode);
        return optionalBranch.orElse(null);
    }
}
