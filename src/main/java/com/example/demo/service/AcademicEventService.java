package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AcademicEvent;

@Service
public interface AcademicEventService {
    AcademicEvent createEvent(AcademicEvent event);
    AcademicEvent getEventByBranch(Long branchId);
    AcademicEvent updateEvent(Long id, AcademicEvent event);
    AcademicEvent getEventById(Long id);
    List<AcademicEvent>getAllEvent();
    List<AcademicEvent> getEventsByBranch(Long branchId);




    
}
