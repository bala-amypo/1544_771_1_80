package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    // used by controller
    EventMergeRecord mergeEvents(List<Long> eventIds, String mergedBy);

    EventMergeRecord getMergeRecordById(Long id);

    List<EventMergeRecord> getAllMergeRecords();

    List<EventMergeRecord> getMergeRecordsByDate(
            LocalDate startDate,
            LocalDate endDate
    );
}
