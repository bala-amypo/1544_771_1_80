package com.example.academic.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HarmonizedCalender {
    private Long id;
    private String title;
    private String generatedBy;
    private LocalDateTime gernatedAt;
    private LocalDate efectiveFrom;
    private LocalDate effectiveTo;
     private String eventJson;

    public HarmonizedCalender(String title, String generatedBy, LocalDateTime gernatedAt, LocalDate efectiveFrom,
            LocalDate effectiveTo, String eventJson) {
        this.title = title;
        this.generatedBy = generatedBy;
        this.gernatedAt = gernatedAt;
        this.efectiveFrom = efectiveFrom;
        this.effectiveTo = effectiveTo;
        this.eventJson = eventJson;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public LocalDateTime getGernatedAt() {
        return gernatedAt;
    }

    public LocalDate getEfectiveFrom() {
        return efectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public String getEventJson() {
        return eventJson;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public void setGernatedAt(LocalDateTime gernatedAt) {
        this.gernatedAt = gernatedAt;
    }

    public void setEfectiveFrom(LocalDate efectiveFrom) {
        this.efectiveFrom = efectiveFrom;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public void setEventJson(String eventJson) {
        this.eventJson = eventJson;
    }
   

}
