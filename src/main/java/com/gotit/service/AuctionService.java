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

    public AuctionService(AuctionRepository auctionRepository, CategoryRepository categoryRepository, UserRepository userRepository, PurchaseService purchaseService) {
        this.auctionRepository = auctionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.purchaseService = purchaseService;
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
                .sorted(Comparator.comparing(Auction::getEndDate))
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

    private AuctionDTO mapAuctionToAuctionDTO(Auction auction) {
        return new AuctionDTO().setId(auction.getId())
                .setTitle(auction.getTitle())
                .setDescription(auction.getDescription())
                .setPhoto(auction.getPhoto())
                .setCategory(auction.getCategory().getName())
                .setMinPrice(auction.getMinPrice())
                .setBuyNowPrice(auction.getBuyNowPrice())
                .setPromotedAuction(auction.getPromotedAuction())
                .setLocalization(auction.getLocalization())
                .setDateOfIssue(auction.getDateOfIssue())
                .setEndDate(auction.getEndDate())
                .setNumberOfVisits(auction.getNumberOfVisits())
                .setFinished(auction.isFinished())
                .build();
    }

    private List<AuctionDTO> convertAuctionListToAuctionDTOList(List<Auction> auctions) {
        List<AuctionDTO> auctionsDTO = new ArrayList<>();
        for (Auction auction : auctions) {
            auctionsDTO.add(mapAuctionToAuctionDTO(auction)
            );
        }
        return auctionsDTO;
    }


    public AuctionDTO findAuction(String id) {
        return mapAuctionToAuctionDTO(auctionRepository.findById(Long.parseLong(id)).orElseThrow());
    }

    public List<AuctionDTO> findCategoryProducts(String categoryName) {
        Category foundCategory = categoryRepository.findByName(categoryName).orElseThrow();
        return convertAuctionListToAuctionDTOList(auctionRepository.findAllByCategory(foundCategory).orElseThrow().stream().filter(e -> !e.isFinished()).collect(Collectors.toList()));
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
        auctionRepository.save(auction);
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        purchaseService.addPurchase(new Purchase(auction, userAccount, auction.getBuyNowPrice()));
        return mapAuctionToAuctionDTO(auction);

    }

}
