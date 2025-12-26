package com.example.demo.service.impl;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public EventMergeRecord saveMerge(EventMergeRecord record) {
        return repository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMerges() {
        return repository.findAll();
    }
}
