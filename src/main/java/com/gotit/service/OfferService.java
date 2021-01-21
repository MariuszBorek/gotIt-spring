package com.gotit.service;

import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    public List<Auction> findUserAuctions(String email) {
        UserAccount userAccount = userRepository.findByEmail(email).orElseThrow();
        List<Offer> offers = offerRepository.findAllByUserAccount(userAccount).orElseThrow();
        return offers.stream().map(Offer::getAuction).collect(Collectors.toList());
    }


}
