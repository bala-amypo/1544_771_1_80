package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String location;
    private boolean active = true;

    private LocalDateTime lastSyncAt;

    public BranchProfile() {}

    @PrePersist
    public void prePersist() {
        lastSyncAt = LocalDateTime.now();
    }

    // ✅ REQUIRED setters/getters
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public void setBranchName(String branchName) { this.branchName = branchName; }
    public String getBranchName() { return branchName; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
