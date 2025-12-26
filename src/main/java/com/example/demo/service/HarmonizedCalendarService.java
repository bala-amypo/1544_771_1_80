package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendar;
import java.util.List;

public interface HarmonizedCalendarService {

    HarmonizedCalendar generate(HarmonizedCalendar calendar);

    List<HarmonizedCalendar> getAll();
}
