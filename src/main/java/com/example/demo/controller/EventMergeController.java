package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;


@RestController
@RequestMapping("/api/merge-records")

public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    
    @PostMapping
    public EventMergeRecord mergeEvents(
            @RequestParam List<Long> eventIds,
            @RequestParam String reason) {
        return service.mergeEvents(eventIds, reason);
    }

  
    @GetMapping("/{id}")
    public EventMergeRecord getById(@PathVariable Long id) {
        return service.getMergeRecordById(id);
    }

    
    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAllMergeRecords();
    }
    @GetMapping("/range")
    public List<EventMergeRecord> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return service.getMergeRecordsByDate(start, end);
    }
}
