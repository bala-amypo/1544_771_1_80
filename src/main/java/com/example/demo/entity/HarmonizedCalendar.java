package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "harmonized_calendars")
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String generatedBy;

    @Column(length = 5000)
    private String eventsJson;

    public HarmonizedCalendar() {
    }

    // ---------- GETTERS ----------

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public String getEventsJson() {
        return eventsJson;
    }

    // ---------- SETTERS (🔥 MISSING BEFORE) ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public void setEventsJson(String eventsJson) {
        this.eventsJson = eventsJson;
    }
}
