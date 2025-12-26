package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository mergeRepository;

    public EventMergeServiceImpl(EventMergeRecordRepository mergeRepository) {
        this.mergeRepository = mergeRepository;
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(
            LocalDate startDate,
            LocalDate endDate) {

        return mergeRepository
                .findByMergedStartDateGreaterThanEqualAndMergedEndDateLessThanEqual(
                        startDate, endDate
                );
    }
}
