// package com.example.demo.repository;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.UserAccount;

// public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

//     Optional<UserAccount> findByUsername(String username);
// }
package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);
}
