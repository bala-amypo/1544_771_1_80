package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;

public interface EventMergeService {
    AcademicEvent mergeEvents(AcademicEvent existing, AcademicEvent incoming);
}
