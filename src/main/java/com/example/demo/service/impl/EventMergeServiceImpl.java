package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRepository;
import com.example.demo.service.EventMergeService;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRepository repository;

    public EventMergeServiceImpl(EventMergeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(
                eventIds.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));

        record.setMergedTitle("Merged Event");
        record.setMergeReason(reason);
        record.setMergeStartDate(LocalDate.now());
        record.setMergeEndDate(LocalDate.now());

        return repository.save(record);
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return repository.findAll();
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repository.findByMergeStartDateBetween(start, end);
    }
}
