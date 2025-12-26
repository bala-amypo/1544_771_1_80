package com.example.demo.service;

import com.example.demo.entity.MergeRecord;
import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {

    MergeRecord mergeEvents(List<Long> eventIds, String reason);

    List<MergeRecord> getAllMergeRecords();

    MergeRecord getMergeRecordById(Long id);

    List<MergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end);
}
