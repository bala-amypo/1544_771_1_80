package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import org.springframework.stereotype.Service;

@Service
public class AcademicEventServiceImpl {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    public AcademicEvent save(AcademicEvent event) {
        return repository.save(event);
    }
}
