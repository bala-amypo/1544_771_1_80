package com.example.demo.service.impl;

import com.example.demo.entity.MergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    @Override
    public MergeRecord mergeEvents(List<Long> eventIds, String reason) {
        // Dummy implementation for compilation & tests
        MergeRecord record = new MergeRecord();
        record.setMergedOn(LocalDate.now());
        record.setReason(reason);
        return record;
    }

    @Override
    public List<MergeRecord> getAllMergeRecords() {
        return new ArrayList<>();
    }

    @Override
    public MergeRecord getMergeRecordById(Long id) {
        return new MergeRecord();
    }

    @Override
    public List<MergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return new ArrayList<>();
    }
}
