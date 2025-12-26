package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    List<EventMergeRecord> getMergeRecordsByDate(
            LocalDate startDate,
            LocalDate endDate
    );
}
