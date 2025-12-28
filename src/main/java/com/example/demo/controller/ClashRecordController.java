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
















