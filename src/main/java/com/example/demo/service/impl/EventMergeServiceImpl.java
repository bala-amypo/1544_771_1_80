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
    public EventMergeRecord mergeEvents(List<Long> eventIds, String mergedBy) {
        EventMergeRecord record = new EventMergeRecord();
        record.setMergedBy(mergedBy);
        record.setMergedStartDate(LocalDate.now());
        record.setMergedEndDate(LocalDate.now());
        return mergeRepository.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return mergeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return mergeRepository.findAll();
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
