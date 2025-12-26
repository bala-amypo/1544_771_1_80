package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_profiles")
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String location;

    public BranchProfile() {}

    public BranchProfile(Long id, String branchCode,
                         String branchName, String location) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
