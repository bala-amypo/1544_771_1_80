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
        Optional<AcademicEvent> optionalEvent =
                academicEventRepository.findById(id);

        if (!optionalEvent.isPresent()) {
            return null;   // no exception
        }

        AcademicEvent existingEvent = optionalEvent.get();
        existingEvent.setEventType(event.getEventType());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setBranchId(event.getBranchId());

        return academicEventRepository.save(existingEvent);
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
