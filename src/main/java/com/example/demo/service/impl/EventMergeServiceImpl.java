package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecord record = new EventMergeRecord();
        record.setMergedOn(LocalDate.now());
        record.setReason(reason);
        return record;
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return new ArrayList<>();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return new EventMergeRecord();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return new ArrayList<>();
    }
}
