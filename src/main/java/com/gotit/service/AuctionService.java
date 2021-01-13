package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.entity.Auction;
import com.gotit.entity.AuctionRepository;
import com.gotit.entity.Category;
import com.gotit.entity.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final CategoryRepository categoryRepository;

    public AuctionService(AuctionRepository auctionRepository, CategoryRepository categoryRepository) {
        this.auctionRepository = auctionRepository;
        this.categoryRepository = categoryRepository;
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
        return convertAuctionListToAuctionDTOList(auctionRepository.findAllByCategory(foundCategory).orElseThrow());
    }

    public List<AuctionDTO> findAuctionsByPhrase(String phrase) {
        return convertAuctionListToAuctionDTOList(auctionRepository.findAll().stream()
                .filter(e -> e.getTitle().toLowerCase().matches(".*" + phrase.toLowerCase() + ".*"))
                .collect(Collectors.toList())
        );
    }
}
