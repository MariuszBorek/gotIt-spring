package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.service.AuctionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public AuctionDTO getFiveEndedAuctions(@PathVariable("id") final String id) {
        return auctionService.findAuction(id);
    }

}
