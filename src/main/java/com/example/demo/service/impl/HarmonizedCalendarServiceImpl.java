// package com.example.demo.service.impl;

// import com.example.demo.entity.AcademicEvent;
// import com.example.demo.entity.HarmonizedCalendar;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AcademicEventRepository;
// import com.example.demo.repository.HarmonizedCalendarRepository;
// import com.example.demo.service.HarmonizedCalendarService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

//     private final HarmonizedCalendarRepository calendarRepo;
//     private final AcademicEventRepository eventRepo;

//     public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository calendarRepo,
//                                          AcademicEventRepository eventRepo) {
//         this.calendarRepo = calendarRepo;
//         this.eventRepo = eventRepo;
//     }

//     @Override
//     public HarmonizedCalendar generateCalendar(String title, String generatedBy) {

//         List<AcademicEvent> events = eventRepo.findAll();

//         HarmonizedCalendar calendar = new HarmonizedCalendar();
//         calendar.setTitle(title);
//         calendar.setGeneratedBy(generatedBy);
//         calendar.setEventsJson(events.toString());

//         return calendarRepo.save(calendar);
//     }

//     @Override
//     public List<HarmonizedCalendar> getAllCalendars() {
//         return calendarRepo.findAll();
//     }

//     @Override
//     public HarmonizedCalendar getCalendar(Long id) {
//         return calendarRepo.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Calendar not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository harmonizedCalendarRepository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repo) {
        this.harmonizedCalendarRepository = repo;
    }

    @Override
    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy) {
        HarmonizedCalendar cal = new HarmonizedCalendar();
        cal.setTitle(title);
        cal.setGeneratedBy(generatedBy);
        cal.setGeneratedAt(LocalDateTime.now());
        return harmonizedCalendarRepository.save(cal);
    }

    @Override
    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate start, LocalDate end) {
        return harmonizedCalendarRepository
                .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(start, end);
    }
}
