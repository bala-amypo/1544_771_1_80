// // // package com.example.demo.service;

// // // import com.example.demo.entity.ClashRecord;

// // // import java.util.List;

// // // public interface ClashDetectionService {

// // //     List<ClashRecord> detectClashes();

// // //     ClashRecord resolveClash(Long id);
// // // }




// package com.example.demo.service;

// import com.example.demo.entity.ClashRecord;
// import java.util.List;

// public interface ClashDetectionService {


   
//     List<ClashRecord> detectClashes();
//     List<ClashRecord> getClashesForEvent(Long eventId);
//     List<ClashRecord> getUnresolvedClashes();
//     ClashRecord resolveClash(Long id);
    
// }


   





ClashDetectionService.java:
 	package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashDetectionService {
    ClashRecord logClash(ClashRecord clash);
    List<ClashRecord> getClashesForEvent(Long eventId);
    ClashRecord resolveClash(Long clashId);
    List<ClashRecord> getUnresolvedClashes();
    List<ClashRecord> getAllClashes();
}


EventMergeService.java:
           package com.example.demo.service;

import com.example.demo.entity.EventMergeRecord;
import java.time.LocalDate;
import java.util.List;

public interface EventMergeService {
    EventMergeRecord mergeEvents(List<Long> eventIds, String reason);
    List<EventMergeRecord> getAllMergeRecords();
    EventMergeRecord getMergeRecordById(Long id);
    List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end);
}