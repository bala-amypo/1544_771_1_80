package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String description;

    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ClashRecord() {}

    public ClashRecord(Long id, String clashType, String severity) {
        this.id = id;
        this.clashType = clashType;
        this.severity = severity;
    }

    // 🔥 REQUIRED BY TEST
    public ClashRecord(Long id, Long eventAId, Long eventBId,
                       String clashType, String severity, String description,
                       LocalDateTime detectedAt, boolean resolved) {
        this.id = id;
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.description = description;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        if (resolved == null) resolved = false;
    }

    public Boolean getResolved() { return resolved; }
    public Long getEventAId() { return eventAId; }
    public Long getEventBId() { return eventBId; }
}
