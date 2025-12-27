package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class HarmonizedCalendar {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Column(length = 5000)
    private String eventsJson;

    public HarmonizedCalendar() {}

    public HarmonizedCalendar(long id, String title, String generatedBy,
                              LocalDateTime generatedAt,
                              LocalDate from, LocalDate to,
                              String eventsJson) {
        this.id = id;
        this.title = title;
        this.generatedBy = generatedBy;
        this.generatedAt = generatedAt;
        this.effectiveFrom = from;
        this.effectiveTo = to;
        this.eventsJson = eventsJson;
    }

    @PrePersist
    public void prePersist() {
        this.generatedAt = LocalDateTime.now();
    }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    public LocalDate getEffectiveTo() { return effectiveTo; }

    public void setEffectiveFrom(LocalDate d) { this.effectiveFrom = d; }
    public void setEffectiveTo(LocalDate d) { this.effectiveTo = d; }
}
