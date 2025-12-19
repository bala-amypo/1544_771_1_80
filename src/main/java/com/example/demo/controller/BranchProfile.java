package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
@Tag(name = "Branch Profiles")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    // POST /api/branches
    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    // PUT /api/branches/{id}/status?active=true
    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateBranchStatus(id, active);
    }

    // GET /api/branches/{id}
    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    // GET /api/branches
    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return service.getAllBranches();
    }

    
    @GetMapping("/by-code/{branchCode}")
    public BranchProfile getByBranchCode(@PathVariable String branchCode) {
        return service.findByBranchCode(branchCode);
    }
}
