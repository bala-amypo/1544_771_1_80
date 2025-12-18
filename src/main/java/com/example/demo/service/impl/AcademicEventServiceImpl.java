package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

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
        Optional<AcademicEvent> optional =
                academicEventRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        AcademicEvent existing = optional.get();
        existing.setEventType(event.getEventType());
        existing.setEndDate(event.getEndDate());
        existing.setBranchId(event.getBranchId());

        return academicEventRepository.save(existing);
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
