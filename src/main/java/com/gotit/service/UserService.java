package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.UserDTO;
import com.gotit.entity.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AuctionService auctionService;
    private final FileService fileService;
    private final AuctionRepository auctionRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository, AuctionService auctionService, FileService fileService, AuctionRepository auctionRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.auctionService = auctionService;
        this.fileService = fileService;
        this.auctionRepository = auctionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("Username: " + s + " not found."));
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

    public void createUserAuction(MultipartFile imageFile, String category, String title, String description,
                                  String buyNowPrice,String startMinPrice, boolean promotedAuction, String endDate, boolean isAuction, String email) {
        String photoName = "placeholderproduct.jpg";
        if(!imageFile.isEmpty()) {
            try {
                photoName = fileService.saveImage(imageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        UserAccount userAccount = userRepository.findByEmail(email).orElseThrow();
        if(!startMinPrice.isEmpty() && Double.parseDouble(startMinPrice) > 0.0) {
            auctionService.createAuction(photoName, category, title, description, buyNowPrice, startMinPrice, promotedAuction, endDate, userAccount, isAuction);
        } else {
            auctionService.createAuction(photoName, category, title, description, buyNowPrice, "0", promotedAuction, endDate, userAccount, isAuction);
        }

    }

    public List<AuctionDTO> findUserPostedAuctions(String email) {
        UserAccount userAccount = userRepository.findByEmail(email).orElseThrow();
        return auctionService.convertAuctionListToAuctionDTOList(auctionRepository.findAll().stream()
                .filter(e -> e.getAuctionOwner().equals(userAccount))
                .collect(Collectors.toList()));
    }
}
