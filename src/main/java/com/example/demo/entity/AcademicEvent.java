package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "academic_events")
public class AcademicEvent {

    // ========================
    // Fields
    // ========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to BranchProfile
    private Long branchId;

    private String title;

    private String eventType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    @Column(length = 1000)
    private String description;

    private LocalDateTime submittedAt;

    public AcademicEvent() {
    }

    // Parameterized constructor
    public AcademicEvent(
            Long id,
            Long branchId,
            String title,
            String eventType,
            LocalDate startDate,
            LocalDate endDate,
            String location,
            String description,
            LocalDateTime submittedAt
    ) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.submittedAt = submittedAt;

        validateDates();
    }

    

    @PrePersist
    protected void onCreate() {
        this.submittedAt = LocalDateTime.now();
        validateDates();
    }

   

    private void validateDates() {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        validateDates();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        validateDates();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
