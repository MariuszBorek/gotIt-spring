package com.gotit.controller;



import com.gotit.dto.PurchaseDTO;
import com.gotit.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/purchased/")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(path = "/{email}", produces = "application/json")
    public List<PurchaseDTO> getFiveEndedAuctions(@PathVariable("email") final String email) {
        return purchaseService.convertPurchaseListToPurchaseDTOList(purchaseService.getAllPurchasesOfUser(email));
    }
}
