package com.gotit.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Optional<List<Purchase>> findAllByUserAccount(UserAccount userAccount);
}
