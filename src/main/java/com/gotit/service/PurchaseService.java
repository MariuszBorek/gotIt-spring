package com.gotit.service;

import com.gotit.dto.PurchaseDTO;
import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, UserRepository userRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
    }

    public Purchase addPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchasesOfUser(String userEmail) {
        UserAccount userAccount = userRepository.findByEmail(userEmail).orElseThrow();
        return purchaseRepository.findAllByUserAccount(userAccount).orElseThrow();
    }

    public PurchaseDTO mapPurchaseToPurchaseDTO(Purchase purchase) {
        return new PurchaseDTO()
                .setAuctionId(purchase.getAuction().getId())
                .setTitle(purchase.getAuction().getTitle())
                .setDescription(purchase.getAuction().getDescription())
                .setPhoto(purchase.getAuction().getPhoto())
                .setCategory(purchase.getAuction().getCategory().toString())
                .setLocalization(purchase.getAuction().getLocalization())
                .setEndDate(purchase.getAuction().getEndDate())
                .setPrice(purchase.getPrice())
                .build();
    }

    public List<PurchaseDTO> convertPurchaseListToPurchaseDTOList(List<Purchase> purchases) {
        List<PurchaseDTO> purchasesDTO = new ArrayList<>();
        for (Purchase purchase : purchases) {
            purchasesDTO.add(mapPurchaseToPurchaseDTO(purchase)
            );
        }
        return purchasesDTO;
    }


}
