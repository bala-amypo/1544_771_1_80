// package com.example.demo.entity;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import jakarta.persistence.*;

// @Entity
// @Table(name = "harmonized_calendars")
// public class HarmonizedCalendar {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     private String generatedBy;

//     private LocalDateTime generatedAt;

//     private LocalDate effectiveFrom;
//     private LocalDate effectiveTo;

//     private String eventsJson;

//     @PrePersist
//     public void onCreate() {
//         this.generatedAt = LocalDateTime.now();
//     }

//     public Long getId() {
//         return id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public String getGeneratedBy() {
//         return generatedBy;
//     }

//     public LocalDateTime getGeneratedAt() {
//         return generatedAt;
//     }

//     public LocalDate getEffectiveFrom() {
//         return effectiveFrom;
//     }

//     public LocalDate getEffectiveTo() {
//         return effectiveTo;
//     }

//     public String getEventsJson() {
//         return eventsJson;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public void setGeneratedBy(String generatedBy) {
//         this.generatedBy = generatedBy;
//     }

//     public void setGeneratedAt(LocalDateTime generatedAt) {
//         this.generatedAt = generatedAt;
//     }

//     public void setEffectiveFrom(LocalDate effectiveFrom) {
//         this.effectiveFrom = effectiveFrom;
//     }

//     public void setEffectiveTo(LocalDate effectiveTo) {
//         this.effectiveTo = effectiveTo;
//     }

//     public void setEventsJson(String eventsJson) {
//         this.eventsJson = eventsJson;
//     }

    
// }
