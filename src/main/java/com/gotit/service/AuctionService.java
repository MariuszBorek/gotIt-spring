package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final CategoryRepository categoryRepository;
    private final PurchaseService purchaseService;
    private final UserRepository userRepository;
    private final OfferService offerService;

    public AuctionService(AuctionRepository auctionRepository, CategoryRepository categoryRepository,
                          UserRepository userRepository, PurchaseService purchaseService, OfferService offerService) {
        this.auctionRepository = auctionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.purchaseService = purchaseService;
        this.offerService = offerService;
    }



    public List<AuctionDTO> getUserAuctionsBid(String email) {
        return convertAuctionListToAuctionDTOList(offerService.findUserAuctionsBid(email));
    }

    public List<AuctionDTO> findFiveLastAddedAuctions() {
        List<Auction> auctions = auctionRepository.findAll().stream()
                .sorted((e1, e2) -> e2.getDateOfIssue().compareTo(e1.getDateOfIssue()))
                .limit(5)
                .collect(Collectors.toList());
        return convertAuctionListToAuctionDTOList(auctions);
    }

    public List<AuctionDTO> findFiveEndingAuctions() {
        List<Auction> auctions = auctionRepository.findAll().stream()
                .sorted(Comparator.comparing(auction -> auction.getEndDate().isAfter(LocalDate.now())))
                .limit(5)
                .collect(Collectors.toList());
        return convertAuctionListToAuctionDTOList(auctions);
    }

    public List<AuctionDTO> findFiveEndedAuctions() {
        List<Auction> auctions = auctionRepository.findAll().stream()
                .sorted(Comparator.comparing(Auction::getEndDate).reversed())
                .filter((e) -> e.getEndDate().isBefore(LocalDate.now()))
                .limit(5)
                .collect(Collectors.toList());
        return convertAuctionListToAuctionDTOList(auctions);
    }

    public AuctionDTO mapAuctionToAuctionDTO(Auction auction) {
        return new AuctionDTO().setId(auction.getId())
                .setTitle(auction.getTitle())
                .setDescription(auction.getDescription())
                .setPhoto(auction.getPhoto())
                .setCategory(auction.getCategory().getName())
                .setBuyNowPrice(auction.getBuyNowPrice())
                .setPromotedAuction(auction.getPromotedAuction())
                .setLocalization(auction.getLocalization())
                .setDateOfIssue(auction.getDateOfIssue())
                .setEndDate(auction.getEndDate())
                .setNumberOfVisits(auction.getNumberOfVisits())
                .setFinished(auction.isFinished())
                .setOwner(auction.getAuctionOwner().getEmail())
                .setAuction(auction.isAuction())
                .build();
    }

    public List<AuctionDTO> convertAuctionListToAuctionDTOList(List<Auction> auctions) {
        List<AuctionDTO> auctionsDTO = new ArrayList<>();
        for (Auction auction : auctions) {
            auctionsDTO.add(mapAuctionToAuctionDTO(auction)
            );
        }
        return auctionsDTO;
    }


    public AuctionDTO findAuctionDTO(String id) {
        Auction auction = auctionRepository.findById(Long.parseLong(id)).orElseThrow();
        incrementVisits(auction);
        return mapAuctionToAuctionDTO(auction);
    }

    public Auction findAuctionById(String id) {
        return auctionRepository.findById(Long.parseLong(id)).orElseThrow();
    }

    public List<AuctionDTO> findCategoryProducts(String categoryName) {
        Category foundCategory = categoryRepository.findByName(categoryName).orElseThrow();
        return convertAuctionListToAuctionDTOList(auctionRepository.findAllByCategory(foundCategory).orElseThrow().stream()
                .filter(e -> !e.isFinished())
                .collect(Collectors.toList()));
    }

    public List<AuctionDTO> findAuctionsByPhrase(String phrase) {
        return convertAuctionListToAuctionDTOList(auctionRepository.findAll().stream()
                .filter(e -> e.getTitle().toLowerCase().matches(".*" + phrase.toLowerCase() + ".*"))
                .collect(Collectors.toList())
        );
    }

    public AuctionDTO buyProductById(Long auctionId, String userEmail) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow();
        if (auction.isFinished()) {
            return null;
        }
        auction.setFinished(true);
        auction.setEndDate(LocalDate.now());
        auctionRepository.save(auction);
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        purchaseService.addPurchase(new Purchase(auction, userAccount, auction.getBuyNowPrice()));
        return mapAuctionToAuctionDTO(auction);

    }

    public void addToWatchedProducts(Long auctionId, String userEmail) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow();
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        userAccount.getWatchedAuctions().add(auction);
        userRepository.save(userAccount);
    }

    public AuctionDTO findRandomPremiumAuction() {
        List<Auction> collect = auctionRepository.findAll().stream()
                .filter(Auction::getPromotedAuction)
                .collect(Collectors.toList());
        Random random = new Random();
        return mapAuctionToAuctionDTO(collect.get(random.nextInt(collect.size())));
    }

    public void markFinishedAuctions() {
        List<Auction> auctions = auctionRepository.findAll().stream()
                .sorted(Comparator.comparing(Auction::getEndDate).reversed())
                .filter((e) -> e.getEndDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        for (Auction auction : auctions) {
            auction.setFinished(true);
            auctionRepository.save(auction);
        }
    }


    public void createAuction(String photoName, String category, String title, String description,
                              String buyNowPrice, boolean promotedAuction, String endDate,
                              UserAccount auctionOwner, boolean isAuction) {

        Category foundCategory = categoryRepository.findAll().stream()
                .filter(e -> e.getName().equals(category))
                .findFirst().orElseThrow();

        Auction auction = new Auction(title, description, photoName, foundCategory, buyNowPrice,
                promotedAuction, auctionOwner.getAddress().getCity(), LocalDate.now(),
                LocalDate.now().plusDays(Long.parseLong(endDate)), 0, false, auctionOwner, isAuction);
        auctionRepository.save(auction);
    }

    private void incrementVisits(Auction auction) {
        int numberOfVisits = auction.getNumberOfVisits() + 1;
        auction.setNumberOfVisits(numberOfVisits);
        auctionRepository.save(auction);
    }

    public void addNewOffer(String offeredPrice, Long auctionId, String userEmail) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow();
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        Offer offer = new Offer(auction, userAccount, Double.parseDouble(offeredPrice));
        offerService.addOffer(offer);
    }
}
