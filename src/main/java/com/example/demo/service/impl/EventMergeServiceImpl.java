package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventMergeServiceImpl {

    public boolean isOverlapping(AcademicEvent first, AcademicEvent second) {

        LocalDateTime firstStart = first.getStartDate(); // ✅ now exists
        LocalDateTime firstEnd   = first.getEndDate();   // ✅ now exists

        LocalDateTime secondStart = second.getStartDate();
        LocalDateTime secondEnd   = second.getEndDate();

        return !(firstEnd.isBefore(secondStart) ||
                 secondEnd.isBefore(firstStart));
    }
}
