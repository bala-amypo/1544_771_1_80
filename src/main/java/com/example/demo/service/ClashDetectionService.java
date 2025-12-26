package com.example.demo.service;

import com.example.demo.entity.ClashRecord;

import java.util.List;

public interface ClashDetectionService {

    ClashRecord logClash(ClashRecord clashRecord);

    ClashRecord resolveClash(Long id);

    List<ClashRecord> getClashesForEvent(Long eventId);

    List<ClashRecord> getUnresolvedClashes();

    List<ClashRecord> getAllClashes();
}
