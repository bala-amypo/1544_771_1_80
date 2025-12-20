package com.example.demo.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(
    name = "branch_profile",
    uniqueConstraints = @UniqueConstraint(columnNames = "branchCode")
)
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;

    private String clashType;
    private String severity;

    @Column(length = 1000)
    private String details;

    private LocalDateTime detectedAt;

    private boolean resolved = false;

    public ClashRecord() {
    }

    @PrePersist
    public void onCreate() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public Long getId() {
        return id;
    }

    public Long getEventAId() {
        return eventAId;
    }

    public Long getEventBId() {
        return eventBId;
    }

    public String getClashType() {
        return clashType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }

    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }

    public void setClashType(String clashType) {
        this.clashType = clashType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

}