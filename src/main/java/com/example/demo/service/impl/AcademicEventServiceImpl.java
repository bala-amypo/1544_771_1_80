package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository academicEventRepository;

    public AcademicEventServiceImpl(AcademicEventRepository academicEventRepository) {
        this.academicEventRepository = academicEventRepository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        validateDates(event.getStartDate(), event.getEndDate());
        return academicEventRepository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent eventUpdates) {
        AcademicEvent existing = academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        validateDates(eventUpdates.getStartDate(), eventUpdates.getEndDate());

        // Update all updatable fields (do not update submittedAt)
        existing.setBranchId(eventUpdates.getBranchId());
        existing.setTitle(eventUpdates.getTitle());
        existing.setEventType(eventUpdates.getEventType());
        existing.setStartDate(eventUpdates.getStartDate());
        existing.setEndDate(eventUpdates.getEndDate());
        existing.setLocation(eventUpdates.getLocation());
        existing.setDescription(eventUpdates.getDescription());

        return academicEventRepository.save(existing);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return academicEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return academicEventRepository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return academicEventRepository.findAll();
    }

    private void validateDates(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }
    }
}