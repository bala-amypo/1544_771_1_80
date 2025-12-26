package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "academic_events")
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String location;
    private String description;

    public AcademicEvent() {}

    public AcademicEvent(String eventType, String location, String description) {
        this.eventType = eventType;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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
}
