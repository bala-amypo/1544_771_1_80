package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import org.springframework.stereotype.Service;

@Service
public class EventMergeServiceImpl {

    public AcademicEvent mergeEvents(AcademicEvent first, AcademicEvent second) {

        AcademicEvent merged = new AcademicEvent();

        merged.setTitle(first.getTitle());
        merged.setEventType(first.getEventType());
        merged.setLocation(first.getLocation());
        merged.setDescription(first.getDescription());
        merged.setBranchId(first.getBranchId());

        merged.setStartDate(first.getStartDate());
        merged.setEndDate(second.getEndDate());

        return merged;
    }
}
