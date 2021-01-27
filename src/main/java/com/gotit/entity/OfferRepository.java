package com.gotit.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository  extends JpaRepository<Offer, Long> {
    Optional<List<Offer>> findAllByUserAccount(UserAccount userAccount);
    Optional<List<Offer>> findAllByAuction(Auction auction);
    Optional<Offer> findByAuctionAndUserAccount(Auction auction, UserAccount userAccount);
}
