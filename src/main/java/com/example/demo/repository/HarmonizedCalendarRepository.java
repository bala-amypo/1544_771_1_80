package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendar, Long> {

    @Query("""
        SELECT h FROM HarmonizedCalendar h
        WHERE h.startDate <= :end
        AND h.endDate >= :start
    """)
    List<HarmonizedCalendar> findByDateRange(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end);
}
