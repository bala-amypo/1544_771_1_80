package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(@PathVariable Long id,
                                      @RequestParam boolean active) {
        return service.updateBranchStatus(id, active);
    }

    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    @GetMapping
    public List<BranchProfile> getAll() {
        return service.getAllBranches();
    }

    @GetMapping("/lookup/{branchCode}")
    public BranchProfile getByCode(@PathVariable String branchCode) {
        return service.findByBranchCode(branchCode);
    }
}
