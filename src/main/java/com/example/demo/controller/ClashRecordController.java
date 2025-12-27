// package com.example.demo.controller;

// import com.example.demo.entity.ClashRecord;
// import com.example.demo.service.ClashDetectionService;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import io.swagger.v3.oas.annotations.security.SecurityRequirement;

// import java.util.List;

// @RestController
// @RequestMapping("/api/clashes")
// @SecurityRequirement(name = "bearerAuth")
// public class ClashRecordController {

//     private final ClashDetectionService clashService;

//     public ClashRecordController(ClashDetectionService clashService) {
//         this.clashService = clashService;
//     }

//     @GetMapping
//     public ResponseEntity<List<ClashRecord>> detectClashes() {
//         return ResponseEntity.ok(clashService.detectClashes());
//     }

//     @PutMapping("/{id}/resolve")
//     public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
//         return ResponseEntity.ok(clashService.resolveClash(id));
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
@SecurityRequirement(name = "bearerAuth")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    // ✅ POST /api/clashes — Log a clash
    @PostMapping
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clashRecord) {
        return ResponseEntity.ok(clashService.logClash(clashRecord));
    }

    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashService.resolveClash(id));
    }

   
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashService.getClashesByEvent(eventId));
    }

    
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        return ResponseEntity.ok(clashService.getUnresolvedClashes());
    }

   
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashService.getAllClashes());
    }
}
