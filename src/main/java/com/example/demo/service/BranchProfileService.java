// package com.example.academic.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.academic.entity.BranchProfile;

// @Service
// public interface BranchProfileService {

    
//     BranchProfile createBranch(BranchProfile branch);
//     BranchProfile updateBranchStatus(Long id,boolean active);
//     List<BranchProfile>getAllBranches();
//     BranchProfile getBranchById(Long id);
//     BranchProfile findByBr
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {

    BranchProfile createBranch(BranchProfile branch);

    BranchProfile updateBranchStatus(Long id, boolean active);

    BranchProfile getBranchById(Long id);

    List<BranchProfile> getAllBranches();

    BranchProfile findByBranchCode(String branchCode);
}
