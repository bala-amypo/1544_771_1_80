package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventRepository eventRepository;

    public EventMergeServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event mergeEvents(Long primaryEventId, List<Long> secondaryEventIds) {

        Event primaryEvent = eventRepository.findById(primaryEventId)
                .orElseThrow(() -> new ResourceNotFoundException("Primary event not found"));

        List<Event> secondaryEvents = eventRepository.findAllById(secondaryEventIds);

        if (secondaryEvents.isEmpty()) {
            throw new ResourceNotFoundException("No secondary events found");
        }

        for (Event event : secondaryEvents) {
            // Example merge logic
            primaryEvent.getSessions().addAll(event.getSessions());
            eventRepository.delete(event);
        }

        return eventRepository.save(primaryEvent);
    }
}
