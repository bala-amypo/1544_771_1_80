package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEvent;
    private String mergedEvent;
    private LocalDate mergeDate;

    public EventMergeRecord() {
    }

    public EventMergeRecord(String sourceEvent, String mergedEvent, LocalDate mergeDate) {
        this.sourceEvent = sourceEvent;
        this.mergedEvent = mergedEvent;
        this.mergeDate = mergeDate;
    }

    public Long getId() {
        return id;
    }

    public String getSourceEvent() {
        return sourceEvent;
    }

    public void setSourceEvent(String sourceEvent) {
        this.sourceEvent = sourceEvent;
    }

    public String getMergedEvent() {
        return mergedEvent;
    }

    public void setMergedEvent(String mergedEvent) {
        this.mergedEvent = mergedEvent;
    }

    public LocalDate getMergeDate() {
        return mergeDate;
    }

    public void setMergeDate(LocalDate mergeDate) {
        this.mergeDate = mergeDate;
    }
}
