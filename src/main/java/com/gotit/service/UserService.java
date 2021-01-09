package com.gotit.service;

import com.gotit.dto.UserDTO;
import com.gotit.entity.User;
import com.gotit.entity.UserRepository;
import com.gotit.enumerate.AccountType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(()->new UsernameNotFoundException("Username: " + s + " not found."));
    }

    public void addUser(UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), userDTO.getPassword(), userDTO.getName(), userDTO.getSurName(), "some account", LocalDate.now(), "/static/photos/sample.jpg", AccountType.PUBLIC);
        userRepository.save(user);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }
}
