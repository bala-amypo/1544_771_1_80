package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        Optional<AcademicEvent> event = repository.findById(id);
        return event.orElse(null);
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent eventDetails) {
        AcademicEvent event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(eventDetails.getTitle());
        event.setEventType(eventDetails.getEventType());
        event.setLocation(eventDetails.getLocation());
        event.setDescription(eventDetails.getDescription());
        event.setStartTime(eventDetails.getStartTime());
        event.setEndTime(eventDetails.getEndTime());

        return repository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}
