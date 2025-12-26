package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;

    private LocalDateTime createdAt;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String sourceEventIds,
                            LocalDateTime createdAt, String mergeReason) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.createdAt = createdAt;
        this.mergeReason = mergeReason;
    }

    // 🔥 REQUIRED BY TEST
    public EventMergeRecord(Long id, String sourceEventIds, String mergedTitle,
                            LocalDate mergedStartDate, LocalDate mergedEndDate,
                            String mergeReason, LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public String getSourceEventIds() { return sourceEventIds; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
