package com.example.demo.repository;

import com.example.demo.entity.ClashRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {
}
package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendar, Long> {
}
