package com.gotit.service;

import com.gotit.entity.User;
import com.gotit.entity.UserRepository;
import com.gotit.enumerate.AccountType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {

    private final UserRepository userRepository;

    public InitService(UserRepository userRepository) {
        this.userRepository = userRepository;
        init();
    }

    private void init() {
        User user = new User("sample", "q", "Jan", "Kowalski", "some account", LocalDate.now(), "/photos/sample.jpg", AccountType.PUBLIC);
        userRepository.save(user);
    }

}
