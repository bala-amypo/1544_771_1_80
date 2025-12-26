package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Override
    public AcademicEvent mergeEvents(AcademicEvent existing, AcademicEvent incoming) {

        if (incoming.getEventType() != null) {
            existing.setEventType(incoming.getEventType());
        }

        if (incoming.getLocation() != null) {
            existing.setLocation(incoming.getLocation());
        }

        if (incoming.getDescription() != null) {
            existing.setDescription(incoming.getDescription());
        }

        return existing;
    }
}
