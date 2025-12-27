// // package com.example.demo.service;

// // import com.example.demo.entity.ClashRecord;

// // import java.util.List;

// // public interface ClashDetectionService {

// //     List<ClashRecord> detectClashes();

// //     ClashRecord resolveClash(Long id);
// // }




// package com.example.demo.service;

// import com.example.demo.entity.ClashRecord;
// import java.util.List;

// public interface ClashDetectionService {
//     List<ClashRecord> detectClashes();
//     List<ClashRecord> getClashesForEvent(Long eventId);
//     List<ClashRecord> getUnresolvedClashes();
//     ClashRecord resolveClash(Long id);
// }







package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository clashRepository;

    public ClashDetectionServiceImpl(ClashRecordRepository clashRepository) {
        this.clashRepository = clashRepository;
    }

    @Override
    public ClashRecord logClash(ClashRecord clashRecord) {
        clashRecord.setResolved(false);
        return clashRepository.save(clashRecord);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = clashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clash not found"));
        clash.setResolved(true);
        return clashRepository.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesByEvent(Long eventId) {
        return clashRepository.findByEventId(eventId);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRepository.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return clashRepository.findAll();
    }
}
