package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new RuntimeException("startDate cannot be after endDate");
        }
        return repository.save(event);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = getEventById(id);
        existing.setTitle(event.getTitle());
        existing.setBranchId(event.getBranchId());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setDescription(event.getDescription());
        return repository.save(existing);
    }
}
