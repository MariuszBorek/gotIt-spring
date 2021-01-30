package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.OfferDTO;
import com.gotit.service.AuctionService;
import com.gotit.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;
    private final OfferService offerService;

    public AuctionController(AuctionService auctionService, OfferService offerService) {
        this.auctionService = auctionService;
        this.offerService = offerService;
    }

    @GetMapping(path = "/highest-bid/{auctionId}", produces = "application/json")
    public OfferDTO getHighestBid(@PathVariable("auctionId") final String auctionId) {
        return offerService.findTheHighestBidForAnAuction(auctionId);
    }

    @GetMapping(path = "/bidding/{email}", produces = "application/json")
    public List<AuctionDTO> getAuctionsBid(@PathVariable("email") final String email) {
        return auctionService.getUserAuctionsBid(email);
    }

    @GetMapping(path = "/watched-auctions/{email}", produces = "application/json")
    public List<AuctionDTO> getWatchedAuctions(@PathVariable("email") final String email) {
        return auctionService.findWatchedAuctions(email);
    }

    @GetMapping(path = "/random-premium-auction", produces = "application/json")
    public AuctionDTO getRandomPremiumAuction() {
        return auctionService.findRandomPremiumAuction();
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

    @GetMapping(path = "/make-offer/{offeredPrice}/{auctionId}/{email}", produces = "application/json")
    public void makeAnOffer(@PathVariable("offeredPrice") final String offeredPrice,
                                  @PathVariable("auctionId") final Long auctionId,
                                  @PathVariable("email") final String email) {
        auctionService.addNewOffer(offeredPrice, auctionId, email);
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
    public AuctionDTO getAuctionById(@PathVariable("id") final String id) {
        return auctionService.findAuctionDTO(id);
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
