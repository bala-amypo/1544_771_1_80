package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    
    @PostMapping
    public ResponseEntity<AcademicEvent> createEvent(
            @RequestBody AcademicEvent event) {

        AcademicEvent createdEvent =
                academicEventService.createEvent(event);

        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {

        AcademicEvent updatedEvent =
                academicEventService.updateEvent(id, event);

        if (updatedEvent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEvent);
    }

   
    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getEventsByBranch(
            @PathVariable Long branchId) {

        List<AcademicEvent> events =
                academicEventService.getEventsByBranch(branchId);

        return ResponseEntity.ok(events);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getEventById(
            @PathVariable Long id) {

        AcademicEvent event =
                academicEventService.getEventById(id);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(event);
    }

   
    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAllEvents() {

        List<AcademicEvent> events =
                academicEventService.getAllEvents();

        return ResponseEntity.ok(events);
    }
}
