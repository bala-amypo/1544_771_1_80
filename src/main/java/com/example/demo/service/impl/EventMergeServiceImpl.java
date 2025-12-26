package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
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
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate from, LocalDate to) {
        return repository.findByMergeDateBetween(from, to);
    }
}
