package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;

public interface BranchProfileService {

    BranchProfile createBranch(BranchProfile branchProfile);

    BranchProfile updateBranchStatus(Long id, boolean active);

    BranchProfile getBranchById(Long id);

    BranchProfile findByBranchCode(String branchCode);

    List<BranchProfile> getAllBranches();
}
