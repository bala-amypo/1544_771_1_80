package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate mergedOn;

    private String reason;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public LocalDate getMergedOn() {
        return mergedOn;
    }

    public String getReason() {
        return reason;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setMergedOn(LocalDate mergedOn) {
        this.mergedOn = mergedOn;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
