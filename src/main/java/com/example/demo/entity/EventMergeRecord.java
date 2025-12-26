package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mergedBy;
    private LocalDateTime mergedAt;
    private String notes;

    public EventMergeRecord() {}

    public EventMergeRecord(Long id, String mergedBy,
                            LocalDateTime mergedAt, String notes) {
        this.id = id;
        this.mergedBy = mergedBy;
        this.mergedAt = mergedAt;
        this.notes = notes;
    }

    @PrePersist
    public void onMerge() {
        this.mergedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMergedBy() { return mergedBy; }
    public void setMergedBy(String mergedBy) { this.mergedBy = mergedBy; }

    public LocalDateTime getMergedAt() { return mergedAt; }
    public void setMergedAt(LocalDateTime mergedAt) { this.mergedAt = mergedAt; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
