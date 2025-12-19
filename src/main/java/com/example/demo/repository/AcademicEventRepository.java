package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AcademicEvent;



@Repository
public interface AcademicEventRepository extends JpaRepository<AcademicEvent ,Long> {

    List<AcademicEvent> findByBranchId(Long branchId);

    
} 
    

