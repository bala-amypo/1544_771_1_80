package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;

import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarService {

    List<HarmonizedCalendar> getCalendarsWithinRange(
            LocalDate startDate,
            LocalDate endDate
    );
}
