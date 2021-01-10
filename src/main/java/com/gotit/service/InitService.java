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
        createCategories();



    }

    private void createCategories() {
        Category category = new Category("Electronics", "computers, laptops and mobile phone", "avatar");
        categoryRepository.save(category);
        category = new Category("Fashion", "clothes and shoes", "avatar");
        categoryRepository.save(category);
        category = new Category("Home and Garden", "furniture, bathroom, bedroom and tools", "avatar");
        categoryRepository.save(category);
        category = new Category("Baby", "children's clothes and accessories", "avatar");
        categoryRepository.save(category);
        category = new Category("Toys", "lego bricks, car toys and dolls", "avatar");
        categoryRepository.save(category);
        category = new Category("Health", "cosmetics and perfumes", "avatar");
        categoryRepository.save(category);
        category = new Category("culture and entertainment", "art, comics and antique", "avatar");
        categoryRepository.save(category);
        category = new Category("sporting goods", "cycling, fishing and fitness", "avatar");
        categoryRepository.save(category);
        category = new Category("motors", "cars, bikes and boats", "avatar");
        categoryRepository.save(category);
        category = new Category("estate", "houses and property", "avatar");
        categoryRepository.save(category);
        category = new Category("company and services", "cleaning, manufacturing and office equipment", "avatar");
        categoryRepository.save(category);

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

