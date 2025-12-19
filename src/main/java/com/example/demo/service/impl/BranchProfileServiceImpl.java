package com.example.demo.service.impl;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository academicEventRepository;

    public AcademicEventServiceImpl(AcademicEventRepository academicEventRepository) {
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return academicEventRepository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        return academicEventRepository.findById(id)
                .map(existing -> {
                    existing.setEventType(event.getEventType());
                    existing.setEndDate(event.getEndDate());
                    existing.setBranchId(event.getBranchId());
                    return academicEventRepository.save(existing);
                })
                .orElse(null);
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return academicEventRepository.findByBranchId(branchId);     
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id).orElse(null);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }
}
