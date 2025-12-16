package com.example.academic.model;

import java.time.LocalDateTime;

public class BranchProfile {
    private long id;
    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime LastSyncAt;
    private Boolean active;
    public BranchProfile(){
        
    }
    public BranchProfile(String branchCode, String branchName, String contactEmail, LocalDateTime lastSyncAt,
            Boolean active) {
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        LastSyncAt = lastSyncAt;
        this.active = active;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getBranchCode() {
        return branchCode;
    }
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public LocalDateTime getLastSyncAt() {
        return LastSyncAt;
    }
    public void setLastSyncAt(LocalDateTime lastSyncAt) {
        LastSyncAt = lastSyncAt;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}
