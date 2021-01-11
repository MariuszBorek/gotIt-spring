package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.entity.Auction;
import com.gotit.entity.AuctionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
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

    private AuctionDTO mapAuctionToAuctionDTO(Auction auction) {
        return new AuctionDTO().setDescription(auction.getDescription())
                .setPhoto(auction.getPhoto())
                .setCategory(auction.getCategory().getName())
                .setMinPrice(auction.getMinPrice())
                .setBuyNowPrice(auction.getBuyNowPrice())
                .setPromotedAuction(auction.getPromotedAuction())
                .setLocalization(auction.getLocalization())
                .setDateOfIssue(auction.getDateOfIssue())
                .setEndDate(auction.getEndDate())
                .setNumberOfVisits(auction.getNumberOfVisits());
    }

    private List<AuctionDTO> convertAuctionListToAuctionDTOList(List<Auction> auctions) {
        List<AuctionDTO> auctionsDTO = new ArrayList<>();
        for (Auction auction : auctions) {
            auctionsDTO.add(mapAuctionToAuctionDTO(auction)
            );
        }
        return auctionsDTO;
    }

    public List<AuctionDTO> findFiveEndedAuctions() {
        List<Auction> auctions = auctionRepository.findAll().stream()
                .sorted(Comparator.comparing(Auction::getEndDate).reversed())
                .filter((e) -> e.getEndDate().isBefore(LocalDate.now()))
                .limit(5)
                .collect(Collectors.toList());
        return convertAuctionListToAuctionDTOList(auctions);
    }
}
