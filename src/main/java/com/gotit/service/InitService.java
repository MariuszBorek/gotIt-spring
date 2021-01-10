package com.gotit.service;

import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;

    public InitService(UserRepository userRepository, AddressRepository addressRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        init();
    }

    private void init() {
        createSampleUsers();



    }

    private void createCategories() {

    }

    private void createSampleUsers() {
        Address address = new Address("Słoneczna",
                "3b",
                "35-321",
                "Wielkopolska",
                "Warszawa");
        addressRepository.save(address);
        UserAccount userAccount = new UserAccount("sample",
                "q",
                "Jan",
                "Kowalski",
                address,
                LocalDate.now(),
                AccountStatus.ACTIVE,
                "photo",
                AccountType.STANDARD);
        userRepository.save(userAccount);
    }

}
//    ELECTRONICS,
//    FASHION,
//    HOME_AND_GARDEN,
//    BABY,
//    TOYS,
//    HEALTH,
//    CULTURE_AND_ENTERTAINMENT,
//    SORTING_GOODS,
//    MOTORS,
//    ESTATE,
//    COLLECTIBLES_AND_ART,
//    COMPANY_AND_SERVICES
