// package com.example.demo.service.impl;

// import com.example.demo.entity.AcademicEvent;
// import com.example.demo.entity.EventMergeRecord;
// import com.example.demo.exception.ValidationException;
// import com.example.demo.repository.AcademicEventRepository;
// import com.example.demo.repository.EventMergeRecordRepository;
// import com.example.demo.service.EventMergeService;

// import org.springframework.stereotype.Service;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class EventMergeServiceImpl implements EventMergeService {

//     private final AcademicEventRepository eventRepo;
//     private final EventMergeRecordRepository mergeRepo;

//     public EventMergeServiceImpl(AcademicEventRepository eventRepo,
//                                  EventMergeRecordRepository mergeRepo) {
//         this.eventRepo = eventRepo;
//         this.mergeRepo = mergeRepo;
//     }

//     @Override
//     public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {

//         if (eventIds == null || eventIds.size() < 2) {
//             throw new ValidationException("At least two events required for merge");
//         }

//         List<AcademicEvent> events = eventRepo.findAllById(eventIds);

//         LocalDate start = events.stream()
//                 .map(AcademicEvent::getStartDate)
//                 .min(LocalDate::compareTo)
//                 .orElse(null);

//         LocalDate end = events.stream()
//                 .map(AcademicEvent::getEndDate)
//                 .max(LocalDate::compareTo)
//                 .orElse(null);

//         EventMergeRecord record = new EventMergeRecord();
//         record.setSourceEventIds(
//                 eventIds.stream()
//                         .map(String::valueOf)
//                         .collect(Collectors.joining(",")));
//         record.setMergedTitle("Merged Event");
//         record.setMergedStartDate(start);
//         record.setMergedEndDate(end);
//         record.setMergeReason(reason);

//         return mergeRepo.save(record);
//     }

//     @Override
//     public List<EventMergeRecord> getAllMerges() {
//         return mergeRepo.findAll();
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final AcademicEventRepository academicEventRepository;
    private final EventMergeRecordRepository eventMergeRecordRepository;

    public EventMergeServiceImpl(AcademicEventRepository academicEventRepository,
                                 EventMergeRecordRepository eventMergeRecordRepository) {
        this.academicEventRepository = academicEventRepository;
        this.eventMergeRecordRepository = eventMergeRecordRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        List<AcademicEvent> events = academicEventRepository.findAllById(eventIds);

        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }

        EventMergeRecord mr = new EventMergeRecord();
        mr.setSourceEventIds(eventIds.stream().map(String::valueOf).collect(Collectors.joining(",")));
        mr.setMergeReason(reason);
        mr.setMergedTitle("Merged Record");
        mr.setMergedStartDate(events.get(0).getStartDate());
        mr.setMergedEndDate(events.get(events.size()-1).getEndDate());

        return eventMergeRecordRepository.save(mr);
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return eventMergeRecordRepository.findByMergedStartDateBetween(start, end);
    }
}
