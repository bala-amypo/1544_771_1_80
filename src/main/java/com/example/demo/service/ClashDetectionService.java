package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashDetectionService {

    ClashRecord saveClash(ClashRecord record);

    List<ClashRecord> getAllClashes();
}
