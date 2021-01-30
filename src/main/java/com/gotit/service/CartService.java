package com.gotit.service;

import com.gotit.dto.AuctionDTO;
import com.gotit.entity.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final AuctionService auctionService;

    public CartService(CartRepository cartRepository, UserRepository userRepository, AuctionService auctionService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.auctionService = auctionService;
    }

    public int checkCartSize(String email) {
        return getUserCart(email).getAuctions().size();
    }

    public void addAuctionToCart(String email, String auctionId) {
        Auction foundAuction = auctionService.findAuctionById(auctionId);
        Cart userCart = getUserCart(email);
        if(!userCart.getAuctions().contains(foundAuction)) {
            userCart.getAuctions().add(foundAuction);
            cartRepository.save(userCart);
        }
    }

    public List<AuctionDTO> findAllAuctionsInUserCart(String email) {
        return auctionService.convertAuctionListToAuctionDTOList(getUserCart(email).getAuctions());
    }

    private Cart getUserCart(String email) {
        UserAccount userAccount = null;
        try {
            userAccount = userRepository.findByEmail(email).orElseThrow();
            return cartRepository.findByUserAccount(userAccount).orElseThrow();
        } catch (NoSuchElementException e) {
            Cart cart = new Cart(userAccount, Collections.emptyList());
            cartRepository.save(cart);
            return cart;
        }
    }





}
