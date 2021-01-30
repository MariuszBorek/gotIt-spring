package com.gotit.service;

import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class InitService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final AuctionRepository auctionRepository;
    private final PurchaseRepository purchaseRepository;
    private final OfferRepository offerRepository;
    private final CartRepository cartRepository;

    public InitService(UserRepository userRepository, AddressRepository addressRepository,
                       CategoryRepository categoryRepository, AuctionRepository auctionRepository,
                       PurchaseRepository purchaseRepository, OfferRepository offerRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.auctionRepository = auctionRepository;
        this.purchaseRepository = purchaseRepository;
        this.offerRepository = offerRepository;
        this.cartRepository = cartRepository;
        init();
    }

    private void init() {
        createSampleUsers();
        createCategories();
        createAuctions();
        createSamplePurchases();
        createSampleWatchedAuctions();
        createUserPostedAuctions();
        createOffers();
        createSampleCart();

    }

    private void createAuctions() {
        UserAccount seller = userRepository.findById(4L).orElseThrow();
        Auction auction = null;
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Apple iPhone XS - 64GB - Gold (T-Mobile) A1920 (CDMA + GSM)" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s" + i, "iphone.png", categoryRepository.findByName("Electronics").orElseThrow(), "7" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Apple iPhone 11 - 120GB - Black Like New!!! premium" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "iphone2.jpg", categoryRepository.findByName("Electronics").orElseThrow(), "4" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("Reebok ZigWild Trail 6 Men's Shoes " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes rebook.png", categoryRepository.findByName("Fashion").orElseThrow(), "8" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "beanbag.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "4" + i, false, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 30; i++) {
            auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "beanbag.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "15" + i, true, "Kraków", LocalDate.now().minusDays(2).plusDays(i), LocalDate.now().plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("T shirt for boy" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "tshirt.png", categoryRepository.findByName("Baby").orElseThrow(), "15" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 35; i++) {
            auction = new Auction("Voici Robotic - MIP Motion Control Robot - Black & White Toy " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "robot.png", categoryRepository.findByName("Toys").orElseThrow(), "10" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Prismacolor PC1150 Premier Colored Pencils - Set of 150 " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "pencils.jpg", categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "11" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Prismacolor PC1150 Premier Colored Pencils - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "pencils.jpg", categoryRepository.findByName("Culture and Entertainment").orElseThrow(), "23" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 20; i++) {
            auction = new Auction("Sport boots for runners - new technology " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes.jpg", categoryRepository.findByName("Sporting goods").orElseThrow(), "25" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Motor yamaha - new!!!" + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "yamaha.jpg", categoryRepository.findByName("Motors").orElseThrow(), "5" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("Flat 65 m2 in nice neighborhood " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Estate").orElseThrow(), "13" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 15; i++) {
            auction = new Auction("House  155 m2 2 levels - premium " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Estate").orElseThrow(), "12" + i, true, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }

        for (int i = 0; i < 15; i++) {
            auction = new Auction("Architectural projects " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Company and Services").orElseThrow(), "11" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
            auctionRepository.save(auction);
        }
        for (int i = 0; i < 25; i++) {
            auction = new Auction("Vital Pea Protein Powder 100% " + i, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Health").orElseThrow(), "12" + i, false, "Kraków", LocalDate.now().plusDays(i), LocalDate.now().minusDays(2).plusDays(i), 23 + i, false, seller, false);
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
                AccountType.STANDARD,
                Collections.emptyList());
        userRepository.save(userAccount);

        address = new Address("Ciemna",
                "54",
                "33-356",
                "Małopolska",
                "Kraków");
        addressRepository.save(address);
        userAccount = new UserAccount("samplesecond@gmail.com",
                "qwerty",
                "Grzegorz",
                "Malinowski",
                address,
                LocalDate.now(),
                AccountStatus.ACTIVE,
                "spongebob.jpg",
                AccountType.PREMIUM,
                Collections.emptyList());
        userRepository.save(userAccount);

        address = new Address("Jasna",
                "23",
                "3-566",
                "Dolnośląskie",
                "wrocław");
        addressRepository.save(address);
        userAccount = new UserAccount("samplethird@gmail.com",
                "qwerty",
                "Anita",
                "Kowal",
                address,
                LocalDate.now(),
                AccountStatus.ACTIVE,
                "spongebob.jpg",
                AccountType.STANDARD,
                Collections.emptyList());
        userRepository.save(userAccount);
    }

    private void createSamplePurchases() {
        UserAccount buyer = userRepository.findById(2L).orElseThrow();
        UserAccount seller = userRepository.findById(4L).orElseThrow();

        Auction auction = new Auction("Apple iPhone XS - 64GB - Gold (T-Mobile) A1920 (CDMA + GSM)", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "iphone.png", categoryRepository.findByName("Electronics").orElseThrow(), "3000", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true, seller, false);
        auctionRepository.save(auction);
        Purchase purchase = new Purchase(auction, buyer, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

        auction = new Auction("Reebok ZigWild Trail 6 Men's Shoes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes.jpg", categoryRepository.findByName("Fashion").orElseThrow(), "350.99", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true, seller, false);
        auctionRepository.save(auction);
        purchase = new Purchase(auction, buyer, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

        auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "99.99", true, "Kraków", LocalDate.now().minusDays(2), LocalDate.now(), 23, true, seller, false);
        auctionRepository.save(auction);
        purchase = new Purchase(auction, buyer, auction.getBuyNowPrice());
        purchaseRepository.save(purchase);

    }

    private void createSampleWatchedAuctions() {
        Auction auction1 = auctionRepository.findById(18L).orElseThrow();
        Auction auction2 = auctionRepository.findById(58L).orElseThrow();
        Auction auction3 = auctionRepository.findById(189L).orElseThrow();

        UserAccount userAccount = userRepository.findById(2L).orElseThrow();
        userAccount.setWatchedAuctions(List.of(auction1, auction2, auction3));

        userRepository.save(userAccount);
    }

    private void createUserPostedAuctions() {
        UserAccount seller = userRepository.findById(2L).orElseThrow();
        UserAccount buyer = userRepository.findById(4L).orElseThrow();

        Auction auction = new Auction("Beats headphones", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "beats.jpg", categoryRepository.findByName("Electronics").orElseThrow(), "999.99", true, "Kraków", LocalDate.now(), LocalDate.now().plusDays(4L), 23, false, seller, false);
        auctionRepository.save(auction);

        auction = new Auction("Reebok ZigWild Trail 6 Men's Shoes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "shoes.jpg", categoryRepository.findByName("Fashion").orElseThrow(), "350.99", false, "Kraków", LocalDate.now(), LocalDate.now().plusDays(6L), 23, false, seller, false);
        auctionRepository.save(auction);

        auction = new Auction("Microsuede 7ft Foam Giant Bean Bag Memory", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "placeholderproduct.jpg", categoryRepository.findByName("Home and Garden").orElseThrow(), "15", false, "Kraków", LocalDate.now(), LocalDate.now().plusDays(1L), 23, false, seller, false);
        auctionRepository.save(auction);

    }

    private void createOffers() {
        UserAccount seller = userRepository.findById(4L).orElseThrow();
        UserAccount buyer1 = userRepository.findById(2L).orElseThrow();
        UserAccount buyer2 = userRepository.findById(6L).orElseThrow();

        Auction auction = new Auction("Apple Beats EP On-Ear czerwone", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "applebeats.png", categoryRepository.findByName("Electronics").orElseThrow(), "999.99", true, "Kraków", LocalDate.now(), LocalDate.now().plusDays(4L), 23, false, seller, true);
        auctionRepository.save(auction);
        Offer offer = new Offer(auction, buyer1, 203);
        offerRepository.save(offer);
        offer = new Offer(auction, buyer2, 403);
        offerRepository.save(offer);

        auction = new Auction("giuseppe zanotti shoes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "zanotti shoes.png", categoryRepository.findByName("Fashion").orElseThrow(), "350.99", false, "Kraków", LocalDate.now(), LocalDate.now().plusDays(6L), 23, false, seller,true);
        auctionRepository.save(auction);
        offer = new Offer(auction, buyer1, 302);
        offerRepository.save(offer);
        offer = new Offer(auction, buyer2, 345);
        offerRepository.save(offer);

        auction = new Auction("Egg Chair", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s", "chair.png", categoryRepository.findByName("Home and Garden").orElseThrow(), "99.99", true, "Kraków", LocalDate.now(), LocalDate.now().plusDays(1L), 23, false, seller, true);
        auctionRepository.save(auction);
        offer = new Offer(auction, buyer1, 999);
        offerRepository.save(offer);
        offer = new Offer(auction, buyer2, 1234);
        offerRepository.save(offer);
    }

    void createSampleCart() {
        UserAccount userAccount = userRepository.findById(2L).orElseThrow();

        Auction auction1 = auctionRepository.findById(148L).orElseThrow();
        Auction auction2 = auctionRepository.findById(212L).orElseThrow();
        Auction auction3 = auctionRepository.findById(230L).orElseThrow();
        Cart cart = new Cart(userAccount, List.of(auction1, auction2, auction3));
        cartRepository.save(cart);
    }

}

