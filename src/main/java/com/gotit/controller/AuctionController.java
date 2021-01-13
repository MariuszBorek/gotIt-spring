package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.service.AuctionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping(path = "/phrase/{phrase}", produces = "application/json")
    public List<AuctionDTO> getAuctionsByPhrase(@PathVariable("phrase") final String phrase) {
        return auctionService.findAuctionsByPhrase(phrase);
    }

    @GetMapping(path = "/category/{category}", produces = "application/json")
    public List<AuctionDTO> getCategoryProducts(@PathVariable("category") final String category) {
        return auctionService.findCategoryProducts(category);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public AuctionDTO getFiveEndedAuctions(@PathVariable("id") final String id) {
        return auctionService.findAuction(id);
    }

    @GetMapping(path = "/last-added-auctions", produces = "application/json")
    public List<AuctionDTO> getFiveLastAddedAuctions() {
        return auctionService.findFiveLastAddedAuctions();
    }

    @GetMapping(path = "/ending-auctions", produces = "application/json")
    public List<AuctionDTO> getFiveEndingAuctions() {
        return auctionService.findFiveEndingAuctions();
    }

    @GetMapping(path = "/ended-auctions", produces = "application/json")
    public List<AuctionDTO> getFiveEndedAuctions() {
        return auctionService.findFiveEndedAuctions();
    }

}