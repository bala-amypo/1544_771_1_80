package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Override
    public List<AcademicEvent> mergeEvents(List<AcademicEvent> events) {

        for (AcademicEvent event : events) {
            event.getStartDate();  
            event.getEndDate();  
        }

        return events;
    }
}//
