package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;

import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    EventMergeRecord getMergeRecordById(Long id);

    List<EventMergeRecord> getAllMergeRecords();

    List<EventMergeRecord> getMergeRecordsByDate(LocalDate from, LocalDate to);

   
    EventMergeRecord mergeEvents(List<Long> eventIds, Long targetEventId, String reason);
}
