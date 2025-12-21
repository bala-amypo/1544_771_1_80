package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    // POST /api/events
    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    // GET /api/events/{id}
    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }

    // GET /api/events
    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAllEvents();
    }

    // GET /api/events/branch/{branchId}
    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(
            @PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }

    // PUT /api/events/{id}
    @PutMapping("/{id}")
    public AcademicEvent updateEvent(
            @PathVariable Long id,
            @RequestBody AcademicEvent event) {
        return academicEventService.updateEvent(id, event);
    }
}
