package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchName;
    private String location;
    private String contactEmail;

    private LocalDateTime lastSyncAt;
    private Boolean active;

    public BranchProfile() {}

    public BranchProfile(Long id, String branchName, String location, String contactEmail) {
        this.id = id;
        this.branchName = branchName;
        this.location = location;
        this.contactEmail = contactEmail;
    }

    public BranchProfile(Long id, String branchName, String location, String contactEmail,
                         LocalDateTime lastSyncAt, Boolean active) {
        this.id = id;
        this.branchName = branchName;
        this.location = location;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        this.lastSyncAt = LocalDateTime.now();
        if (active == null) active = true;
    }

    /* getters & setters */

    public Long getId() { return id; }
    public Boolean getActive() { return active; }
    public LocalDateTime getLastSyncAt() { return lastSyncAt; }

    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
}
