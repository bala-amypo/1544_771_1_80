package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private boolean resolved;

    public ClashRecord() {}

    public ClashRecord(long id, Long a, Long b, String type,
                       String severity, String details,
                       LocalDateTime detectedAt, boolean resolved) {
        this.id = id;
        this.eventAId = a;
        this.eventBId = b;
        this.clashType = type;
        this.severity = severity;
        this.details = details;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public boolean getResolved() { return resolved; }
    public LocalDateTime getDetectedAt() { return detectedAt; }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
