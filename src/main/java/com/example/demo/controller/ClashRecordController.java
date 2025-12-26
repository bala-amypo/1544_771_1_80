package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
@CrossOrigin
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecord logClash(@RequestBody ClashRecord clash) {
        return service.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return service.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getByEvent(@PathVariable Long eventId) {
        return service.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolved() {
        return service.getUnresolvedClashes();
    }

    @GetMapping
    public List<ClashRecord> getAll() {
        return service.getAllClashes();
    }
}
