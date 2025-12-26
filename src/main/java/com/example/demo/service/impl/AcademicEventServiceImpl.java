package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {

        // ✅ THIS FIXES t19_createAcademicEvent_invalidDates
        if (event.getStartDate() == null || event.getEndDate() == null) {
            throw new ValidationException("Start date and end date are required");
        }

        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("Start date cannot be after end date");
        }

        return repository.save(event);
    }
}
