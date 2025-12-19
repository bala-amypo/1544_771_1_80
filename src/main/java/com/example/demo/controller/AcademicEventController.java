package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    @PostMapping
    public ResponseEntity<AcademicEvent> createEvent(@RequestBody AcademicEvent event) {
        AcademicEvent created = academicEventService.createEvent(event);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> updateEvent(@PathVariable Long id,
                                                     @RequestBody AcademicEvent event) {
        AcademicEvent updated = academicEventService.updateEvent(id, event);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getEventsByBranch(@PathVariable Long branchId) {
        List<AcademicEvent> events = academicEventService.getEventsByBranch(branchId);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getEventById(@PathVariable Long id) {
        AcademicEvent event = academicEventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAllEvents() {
        List<AcademicEvent> events = academicEventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
}