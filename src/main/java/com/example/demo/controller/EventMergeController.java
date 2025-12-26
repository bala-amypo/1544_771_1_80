package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merges")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestBody EventMergeRecord record) {
        return service.saveMerge(record);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return service.getAllMerges();
    }
}
