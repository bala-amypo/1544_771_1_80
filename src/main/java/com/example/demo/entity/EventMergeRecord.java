package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceBranch;

    private String targetBranch;

    private String eventName;

    private LocalDateTime mergedAt;

    public EventMergeRecord() {
    }

    public EventMergeRecord(String sourceBranch, String targetBranch, String eventName) {
        this.sourceBranch = sourceBranch;
        this.targetBranch = targetBranch;
        this.eventName = eventName;
        this.mergedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSourceBranch() {
        return sourceBranch;
    }

    public void setSourceBranch(String sourceBranch) {
        this.sourceBranch = sourceBranch;
    }

    public String getTargetBranch() {
        return targetBranch;
    }

    public void setTargetBranch(String targetBranch) {
        this.targetBranch = targetBranch;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getMergedAt() {
        return mergedAt;
    }

    public void setMergedAt(LocalDateTime mergedAt) {
        this.mergedAt = mergedAt;
    }
}
