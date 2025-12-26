package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecord create(@RequestBody ClashRecord record) {
        return service.saveClash(record);
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return service.getAllClashes();
    }
}
