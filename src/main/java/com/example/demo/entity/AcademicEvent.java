package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;
    private String title;
    private String eventType;

    private LocalDate startDate;
    private LocalDate endDate;

    private String createdBy;
    private String remarks;

    private LocalDateTime submittedAt;

    public AcademicEvent() {}

    public AcademicEvent(Long id, String title, LocalDate startDate,
                         LocalDate endDate, BranchProfile branchProfile) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // 🔥 REQUIRED BY TEST
    public AcademicEvent(Long id, Long branchId, String title, String eventType,
                         LocalDate startDate, LocalDate endDate,
                         String createdBy, String remarks,
                         LocalDateTime submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdBy = createdBy;
        this.remarks = remarks;
        this.submittedAt = submittedAt;
    }

    @PrePersist
    public void prePersist() {
        this.submittedAt = LocalDateTime.now();
    }

    public Long getBranchId() { return branchId; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }

    public void setBranchId(Long branchId) { this.branchId = branchId; }
    public void setTitle(String title) { this.title = title; }
    public void setEventType(String eventType) { this.eventType = eventType; }
}
