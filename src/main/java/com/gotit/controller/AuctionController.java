package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.MessageDTO;
import com.gotit.service.AuctionService;
import org.aspectj.bridge.Message;
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

    @GetMapping(path = "/add-to-watched-auction/{id}/{email}", produces = "application/json")
    public void addToWatchedProducts(@PathVariable("id") final Long id,
                                     @PathVariable("email") final String email) {
        auctionService.addToWatchedProducts(id, email);
    }

    @GetMapping(path = "/buyNow/{id}/{email}", produces = "application/json")
    public AuctionDTO buyProduct(@PathVariable("id") final Long id,
                                 @PathVariable("email") final String email) {
        return auctionService.buyProductById(id, email);
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
