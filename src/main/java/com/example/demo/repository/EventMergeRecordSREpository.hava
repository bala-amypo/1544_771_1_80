package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeRepository extends JpaRepository<EventMergeRecord, Long> {

    List<EventMergeRecord> findByMergeStartDateBetween(LocalDate start, LocalDate end);
}
