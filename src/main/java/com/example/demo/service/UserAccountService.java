// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.UserAccount;

// public interface UserAccountService {

//     UserAccount register(UserAccount user);

//     UserAccount getUser(Long id);

//     List<UserAccount> getAllUsers();

//     UserAccount findByEmail(String email);
// }
package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    UserAccount getUser(Long id);

    UserAccount findByEmail(String email);

    List<UserAccount> getAllUsers();
}
