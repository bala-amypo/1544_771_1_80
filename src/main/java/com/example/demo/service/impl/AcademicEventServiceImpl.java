package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import org.springframework.stereotype.Service;

@Service
public class AcademicEventServiceImpl {

    public void printEventDetails(AcademicEvent event) {

        System.out.println(event.getTitle());
        System.out.println(event.getEventType());
        System.out.println(event.getLocation());
        System.out.println(event.getDescription());
        System.out.println(event.getStartDate());
        System.out.println(event.getEndDate());
    }
}
