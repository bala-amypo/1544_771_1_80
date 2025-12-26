// package com.example.academic.entity;

// import java.time.LocalDate;
// import java.time.LocalDateTime;


// public class AcademicEvent {
//     private Long id;
//     private Long branchId;
//     private String title;
//     private String eventType;
//     private LocalDate startDate;
//     private LocalDate endDate;
//     private String location;
//     private String description;
//     private LocalDateTime submittedAt;
//     public AcademicEvent(Long branchId, String title, String eventType, LocalDate startDate, LocalDate endDate,
//             String location, String description, LocalDateTime submittedAt) {
//         this.branchId = branchId;
//         this.title = title;
//         this.eventType = eventType;
//         this.startDate = startDate;
//         this.endDate = endDate;
//         this.location = location;
//         this.description = description;
//         this.submittedAt = submittedAt;
//     }
//     public Long getId() {
//         return id;
//     }
//     public Long getBranchId() {
//         return branchId;
//     }
//     public String getTitle() {
//         return title;
//     }
//     public String getEventType() {
//         return eventType;
//     }
//     public LocalDate getStartDate() {
//         return startDate;
//     }
//     public LocalDate getEndDate() {
//         return endDate;
//     }
//     public String getLocation() {
//         return location;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public LocalDateTime getSubmittedAt() {
//         return submittedAt;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public void setBranchId(Long branchId) {
//         this.branchId = branchId;
//     }
//     public void setTitle(String title) {
//         this.title = title;
//     }
//     public void setEventType(String eventType) {
//         this.eventType = eventType;
//     }
//     public void setStartDate(LocalDate startDate) {
//         this.startDate = startDate;
//     }
//     public void setEndDate(LocalDate endDate) {
//         this.endDate = endDate;
//     }
//     public void setLocation(String location) {
//         this.location = location;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
//     public void setSubmittedAt(LocalDateTime submittedAt) {
//         this.submittedAt = submittedAt;
//     }
   
    
// }
package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.example.demo.exception.ValidationException;

@Entity
@Table(name = "academic_events")
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;

    private String title;

    private String eventType;

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    private String description;

    private LocalDateTime submittedAt;

   
    public AcademicEvent() {}

   
    public AcademicEvent(Long id,
     Long branchId,
     String title,
    String eventType,
     LocalDate startDate,
    LocalDate endDate,
    String location,
    String description,
    LocalDateTime submittedAt) {

                         
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }

        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.submittedAt = submittedAt;
    }

    
    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
    }



    public Long getId() {
        return id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (this.endDate != null && startDate != null && startDate.isAfter(this.endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (this.startDate != null && endDate != null && this.startDate.isAfter(endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }
        this.endDate = endDate;
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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
}
