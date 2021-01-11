package com.gotit.service;

import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final AuctionRepository auctionRepository;

    public InitService(UserRepository userRepository, AddressRepository addressRepository, CategoryRepository categoryRepository, AuctionRepository auctionRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.auctionRepository = auctionRepository;
        init();
    }

    private void init() {
        createSampleUsers();
        createCategories();
        createAuctions();



    }


    private void createAuctions() {
        Auction auction = null;
        for (int i = 0; i < 15; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Electronics").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("premium auction " + i, "photo" + i, categoryRepository.findByName("Electronics").orElseThrow(), "956.99", "15" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Fashion").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Home and Garden").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("premium auction " + i, "photo" + i, categoryRepository.findByName("Home and Garden").orElseThrow(), "67.99", "15" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Baby").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 35; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Toys").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("premium auction " + i, "photo" + i, categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "99.99", "15" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Sporting goods").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("auction " + i, "photo" + i, categoryRepository.findByName("Motors").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("auction " + i, "photo", categoryRepository.findByName("Estate").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("premium auction " + i, "photo", categoryRepository.findByName("Estate").orElseThrow(), "99.99", "15" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }

        for (int i = 0; i < 15; i++) {
            auction = new Auction("auction " + i, "photo", categoryRepository.findByName("Company and Services").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i);
            auctionRepository.save(auction);
        }

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
        category = new Category("Culture and Entertainment", "art, comics and antique", "avatar");
        categoryRepository.save(category);
        category = new Category("Sporting goods", "cycling, fishing and fitness", "avatar");
        categoryRepository.save(category);
        category = new Category("Motors", "cars, bikes and boats", "avatar");
        categoryRepository.save(category);
        category = new Category("Estate", "houses and property", "avatar");
        categoryRepository.save(category);
        category = new Category("Company and Services", "cleaning, manufacturing and office equipment", "avatar");
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

