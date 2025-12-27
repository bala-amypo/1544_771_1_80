package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository eventRepo;
    private final EventMergeRecordRepository mergeRepo;

    public EventMergeServiceImpl(AcademicEventRepository eventRepo,
                                 EventMergeRecordRepository mergeRepo) {
        this.eventRepo = eventRepo;
        this.mergeRepo = mergeRepo;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

        if (eventIds == null || eventIds.size() < 2) {
            throw new ValidationException("At least two events required for merge");
        }

        List<AcademicEvent> events = eventRepo.findAllById(eventIds);

        LocalDate start = events.stream()
                .map(AcademicEvent::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(null);

        LocalDate end = events.stream()
                .map(AcademicEvent::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(null);

        EventMergeRecord record = new EventMergeRecord();
        record.setSourceEventIds(
                eventIds.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
        record.setMergedTitle("Merged Event");
        record.setMergedStartDate(start);
        record.setMergedEndDate(end);
        record.setMergeReason(reason);

        return mergeRepo.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMerges() {
        return mergeRepo.findAll();
    }
}
