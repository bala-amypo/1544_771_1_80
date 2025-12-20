package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
@CrossOrigin
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(
            HarmonizedCalendarService service) {
        this.service = service;
    }

   
    @PostMapping("/generate")
    public HarmonizedCalendar generateCalendar(
            @RequestParam String title,
            @RequestParam String generatedBy) {

        return service.generateHarmonizedCalendar(title, generatedBy);
    }

    
    @GetMapping("/{id}")
    public HarmonizedCalendar getCalendarById(
            @PathVariable Long id) {

        return service.getCalendarById(id);
    }

  
    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return service.getAllCalendars();
    }

   
    @GetMapping("/range")
    public List<HarmonizedCalendar> getCalendarsWithinRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {

        return service.getCalendarsWithinRange(start, end);
    }
}
