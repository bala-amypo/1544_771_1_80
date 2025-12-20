package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
Table(
    name = "branch_profile",
    uniqueConstraints = @UniqueConstraint(columnNames = "branchCode")
)
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String sourceEventIds;

    @Column(nullable = false)
    private String mergedTitle;

    private LocalDate mergeStartDate;

    private LocalDate mergeEndDate;

    private String mergeReason;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public String getMergedTitle() {
        return mergedTitle;
    }

    public LocalDate getMergeStartDate() {
        return mergeStartDate;
    }

    public LocalDate getMergeEndDate() {
        return mergeEndDate;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public void setMergedTitle(String mergedTitle) {
        this.mergedTitle = mergedTitle;
    }

    public void setMergeStartDate(LocalDate mergeStartDate) {
        this.mergeStartDate = mergeStartDate;
    }

    public void setMergeEndDate(LocalDate mergeEndDate) {
        this.mergeEndDate = mergeEndDate;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
}
