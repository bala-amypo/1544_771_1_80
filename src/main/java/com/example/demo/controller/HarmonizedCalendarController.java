// package com.example.demo.controller;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.HarmonizedCalendar;
// import com.example.demo.service.HarmonizedCalendarService;

// @RestController
// @RequestMapping("/api/harmonized-calendars")
// @CrossOrigin
// public class HarmonizedCalendarController {

//     private final HarmonizedCalendarService service;

//     public HarmonizedCalendarController(HarmonizedCalendarService service) {
//         this.service = service;
//     }

//     @PostMapping("/generate")
//     public HarmonizedCalendar generate(@RequestParam String title,
//                                        @RequestParam String generatedBy) {
//         return service.generateHarmonizedCalendar(title, generatedBy);
//     }

//     @GetMapping("/{id}")
//     public HarmonizedCalendar getById(@PathVariable Long id) {
//         return service.getCalendarById(id);
//     }

//     @GetMapping
//     public List<HarmonizedCalendar> getAll() {
//         return service.getAllCalendars();
//     }

//     @GetMapping("/range")
//     public List<HarmonizedCalendar> getByRange(
//             @RequestParam LocalDate start,
//             @RequestParam LocalDate end) {
//         return service.getCalendarsWithinRange(start, end);
//     }
// }
