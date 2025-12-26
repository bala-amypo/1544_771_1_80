package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping
    public HarmonizedCalendar generate(@RequestBody HarmonizedCalendar calendar) {
        return service.generate(calendar);
    }

    @GetMapping
    public List<HarmonizedCalendar> getAll() {
        return service.getAll();
    }
}
