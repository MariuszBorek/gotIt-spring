package com.gotit.service;

import com.gotit.dto.UserDTO;
import com.gotit.entity.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(()->new UsernameNotFoundException("Username: " + s + " not found."));
    }

    @Transactional
    public void addUser(UserDTO userDTO) {
        Address address = new Address(userDTO.getStreet(),
                userDTO.getHouseNumber(),
                userDTO.getPostcode(),
                userDTO.getProvince(),
                userDTO.getCity());
        addressRepository.save(address);
        UserAccount userAccount = new UserAccount(userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getSurname(),
                address,
                LocalDate.now(),
                AccountStatus.ACTIVE,
                "photo",
                AccountType.STANDARD);
        userRepository.save(userAccount);
    }

    public UserAccount getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public UserDTO convertUserAccountEntityToUserDTO(UserAccount userAccount) {
        return new UserDTO(userAccount.getEmail(),
                userAccount.getPassword(),
                userAccount.getName(),
                userAccount.getSurname(),
                userAccount.getAddress().getStreet(),
                userAccount.getAddress().getHouseNumber(),
                userAccount.getAddress().getPostcode(),
                userAccount.getAddress().getProvince(),
                userAccount.getAddress().getCity(),
                userAccount.getAvatar());
    }
}
