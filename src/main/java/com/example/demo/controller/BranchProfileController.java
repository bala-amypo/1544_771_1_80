package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public BranchProfile create(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @GetMapping
    public List<BranchProfile> getAll() {
        return service.getAllBranches();
    }

    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getBranchById(id);
    }
}
