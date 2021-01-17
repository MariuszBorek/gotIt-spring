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
    private final PurchaseRepository purchaseRepository;

    public InitService(UserRepository userRepository, AddressRepository addressRepository, CategoryRepository categoryRepository, AuctionRepository auctionRepository, PurchaseRepository purchaseRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.auctionRepository = auctionRepository;
        this.purchaseRepository = purchaseRepository;
        init();
    }

    private void init() {
        createSampleUsers();
        createCategories();
        createAuctions();
        createSamplePurchases();



    }


    private void createAuctions() {
        Auction auction = null;
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Apple iPhone XS - 64GB - Gold (T-Mobile) A1920 (CDMA + GSM)" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" + i, "iphone.png", categoryRepository.findByName("Electronics").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Apple iPhone 11 - 120GB - Black Like New!!! premium" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Electronics").orElseThrow(), "956.99", "15" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("Reebok ZigWild Trail 6 Men's Shoes " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes rebook.png", categoryRepository.findByName("Fashion").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "67.99", "15" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("T shirt for boy" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "tshirt.png", categoryRepository.findByName("Baby").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 35; i++) {
            auction = new Auction("Voici Robotic - MIP Motion Control Robot - Black & White Toy " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "robot.png", categoryRepository.findByName("Toys").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Prismacolor PC1150 Premier Colored Pencils - Set of 150 " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Prismacolor PC1150 Premier Colored Pencils - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "pencils.jpg", categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "99.99", "15" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("Sport boots for runners - new technology " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes.jpg", categoryRepository.findByName("Sporting goods").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Motor yamaha - new!!!" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Motors").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Flat 65 m2 in nice neighborhood " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Estate").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("House  155 m2 2 levels - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Estate").orElseThrow(), "99.99", "15" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }

        for (int i = 0; i < 15; i++) {
            auction = new Auction("Architectural projects " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Company and Services").orElseThrow(), "99.99", "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Vital Pea Protein Powder 100% " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Health").orElseThrow(), "39.75", "12" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false);
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
                "sampleavatar.jpg",
                AccountType.STANDARD);
        userRepository.save(userAccount);
    }

    private void createSamplePurchases() {
        UserAccount userAccount = userRepository.findById(2L).orElseThrow();

        Auction auction = new Auction("Apple iPhone XS - 64GB - Gold (T-Mobile) A1920 (CDMA + GSM)", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "iphone.png", categoryRepository.findByName("Electronics").orElseThrow(), "99.99", "3000", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true);
        auctionRepository.save(auction);
        Purchase purchase = new Purchase(auction, userAccount, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

        auction = new Auction("Reebok ZigWild Trail 6 Men's Shoes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes.jpg", categoryRepository.findByName("Fashion").orElseThrow(), "350.99", "15", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true);
        auctionRepository.save(auction);
        purchase = new Purchase(auction, userAccount, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

        auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "99.99", "15", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true);
        auctionRepository.save(auction);
        purchase = new Purchase(auction, userAccount, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

    }

}

