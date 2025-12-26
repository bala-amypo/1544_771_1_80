package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecord logClash(ClashRecord clashRecord) {
        return repository.save(clashRecord);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));

        clash.setResolved(true);
        return repository.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return repository.findByEventAIdOrEventBId(eventId, eventId);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return repository.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return repository.findAll();
    }
}
