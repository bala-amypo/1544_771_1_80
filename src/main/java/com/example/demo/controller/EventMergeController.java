package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/event-merge")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @PostMapping("/merge")
    public EventMergeRecord mergeEvents(
            @RequestBody List<Long> eventIds,
            @RequestParam String mergedBy) {

        return eventMergeService.mergeEvents(eventIds, mergedBy);
    }

    @GetMapping("/{id}")
    public EventMergeRecord getMergeRecord(@PathVariable Long id) {
        return eventMergeService.getMergeRecordById(id);
    }

    @GetMapping
    public List<EventMergeRecord> getAllMergeRecords() {
        return eventMergeService.getAllMergeRecords();
    }

    @GetMapping("/by-date")
    public List<EventMergeRecord> getMergeRecordsByDate(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return eventMergeService.getMergeRecordsByDate(startDate, endDate);
    }
}
