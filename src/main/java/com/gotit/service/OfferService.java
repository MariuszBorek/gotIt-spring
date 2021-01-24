package com.gotit.service;

import com.gotit.dto.OfferDTO;
import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final AuctionRepository auctionRepository;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, AuctionRepository auctionRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.auctionRepository = auctionRepository;
    }

    public void addOffer(Offer offer) {
        offerRepository.save(offer);
    }

    public List<Auction> findUserAuctionsBid(String email) {
        UserAccount userAccount = userRepository.findByEmail(email).orElseThrow();
        List<Offer> offers = offerRepository.findAllByUserAccount(userAccount).orElseThrow();
        return offers.stream().map(Offer::getAuction).collect(Collectors.toList());
    }

    public OfferDTO findTheHighestBidForAnAuction(String auctionId) {
        Auction auction = auctionRepository.findById(Long.parseLong(auctionId)).orElseThrow();
        if(!auction.isAuction()) {
            return null;
        }
        return mapOfferToOfferDTO(offerRepository.findAllByAuction(auction).orElseThrow().stream().min((o1, o2) -> (int) o2.getPrice() - (int) o1.getPrice()).orElseThrow());
    }


    private OfferDTO mapOfferToOfferDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setPrice(offer.getPrice());
        offerDTO.setUserEmail(offer.getUserAccount().getEmail());
        offerDTO.setAuctionId(offer.getId().toString());
        return offerDTO;
    }

}
