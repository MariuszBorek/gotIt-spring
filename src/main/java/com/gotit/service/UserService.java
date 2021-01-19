package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.UserDTO;
import com.gotit.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AuctionService auctionService;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, AddressRepository addressRepository, AuctionService auctionService) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.auctionService = auctionService;
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
                AccountType.STANDARD,
                Collections.emptyList());
        userRepository.save(userAccount);
    }

    public List<AuctionDTO> findWatchedAuctions(String email) {
        try {
            UserAccount userAccount = userRepository.findByEmail(email).orElseThrow();
            return auctionService.convertAuctionListToAuctionDTOList(userAccount.getWatchedAuctions());
        } catch (NoSuchElementException e) {
            logger.info("user do not load yet");
            return null;
        }
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

    public void updateUserData(UserDTO userDTO, String userEmail) {
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        Address address = addressRepository.findById(userAccount.getAddress().getId()).orElseThrow();

        address.setStreet(userDTO.getStreet());
        address.setHouseNumber(userDTO.getHouseNumber());
        address.setPostcode(userDTO.getPostcode());
        address.setProvince(userDTO.getProvince());
        address.setCity(userDTO.getCity());
        addressRepository.save(address);


        userAccount.setName(userDTO.getName());
        userAccount.setSurname(userDTO.getSurname());
        userRepository.save(userAccount);

    }
}
