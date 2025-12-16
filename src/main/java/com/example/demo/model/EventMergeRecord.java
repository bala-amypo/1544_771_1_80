package com.example.academic.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public  class EventMergeRecord {

    private Long  id;
    private String sourceEventIds;
    private String mergedTitle ;
    private LocalDate mergedStartDate;
     private LocalDate mergedendDate;
     private String mergeReason;
     private LocalDateTime createdAt;
     public EventMergeRecord(String sourceEventIds, String mergedTitle, LocalDate mergedStartDate,
            LocalDate mergedendDate, String mergeReason, LocalDateTime createdAt) {
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedendDate = mergedendDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
     }
     public Long getId() {
         return id;
     }
     public String getSourceEventIds() {
         return sourceEventIds;
     }
     public String getMergedTitle() {
         return mergedTitle;
     }
     public LocalDate getMergedStartDate() {
         return mergedStartDate;
     }
     public LocalDate getMergedendDate() {
         return mergedendDate;
     }
     public String getMergeReason() {
         return mergeReason;
     }
     public void setId(Long id) {
        this.id = id;
    }
     public void setSourceEventIds(String sourceEventIds) {
         this.sourceEventIds = sourceEventIds;
     }
     public void setMergedTitle(String mergedTitle) {
         this.mergedTitle = mergedTitle;
     }
     public void setMergedStartDate(LocalDate mergedStartDate) {
         this.mergedStartDate = mergedStartDate;
     }
     public void setMergedendDate(LocalDate mergedendDate) {
         this.mergedendDate = mergedendDate;
     }
     public void setMergeReason(String mergeReason) {
         this.mergeReason = mergeReason;
     }
     public void setCreatedAt(LocalDateTime createdAt) {
         this.createdAt = createdAt;
     }
     public LocalDateTime getCreatedAt() {
         return createdAt;
     }

}
