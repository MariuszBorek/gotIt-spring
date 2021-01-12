package com.gotit.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Optional<List<Auction>> findAllByCategory(Category category);
}
