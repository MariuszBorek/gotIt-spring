package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.UserDTO;
import com.gotit.dto.MessageDTO;
import com.gotit.service.CartService;
import com.gotit.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final CartService cartService;

    public UserController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @DeleteMapping("/remove-product-from-cart/{email}/{auctionId}")
    public List<AuctionDTO> removeProductFromCart(@PathVariable("email") final String email,
                                                  @PathVariable("auctionId") final String auctionId) {
        return cartService.deleteProductFromCart(email, auctionId);
    }

    @GetMapping("/check-cart-size/{email}")
    public int getCartSize(@PathVariable("email") final String email) {
        return cartService.checkCartSize(email);
    }

    @GetMapping("/add-to-cart/{email}/{auctionId}")
    public boolean updateUserData(@PathVariable("email") final String email,
                                  @PathVariable("auctionId") final String auctionId) {
        cartService.addAuctionToCart(email, auctionId);
        return true;
    }

    @GetMapping(path = "/cart/{email}", produces = "application/json")
    public List<AuctionDTO> getAuctionsInCart(@PathVariable("email") final String email) {
        return cartService.findAllAuctionsInUserCart(email);
    }

    @PostMapping("/set-up-auction/{email}")
    public void createAuction(@RequestParam("imageFile") final MultipartFile imageFile,
                              @RequestParam("category") final String category,
                              @RequestParam("title") final String title,
                              @RequestParam("description") final String description,
                              @RequestParam("buyNowPrice") final String buyNowPrice,
                              @RequestParam("promotedAuction")final  boolean promotedAuction,
                              @RequestParam("endDate") final String endDate,
                              @RequestParam("isAuction") final boolean isAuction,
                              @PathVariable("email") final String email) throws IOException {
        userService.createUserAuction(imageFile, category, title, description, buyNowPrice, promotedAuction, endDate, isAuction, email);
    }


    @GetMapping(path = "/posted-auctions/{email}", produces = "application/json")
    public List<AuctionDTO> getUserPostedAuctions(@PathVariable("email") final String email) {
        return userService.findUserPostedAuctions(email);
    }

    @PostMapping("/update-user-data/{email}")
    public boolean updateUserData(@RequestBody UserDTO userDTO,
                                  @PathVariable("email") final String email) {
        userService.updateUserData(userDTO, email);
        return true;
    }

    @GetMapping(path = "/validateLogin", produces = "application/json")
    public MessageDTO validateLogin() {
        return new MessageDTO("User successfully authenticated");
    }

    @PostMapping("/create")
    public boolean createUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return true;
    }

    @GetMapping(path = "/profile/{email}", produces = "application/json")
    public UserDTO getUserData(@PathVariable("email") final String email) {
        return userService.convertUserAccountEntityToUserDTO(userService.getUser(email));
    }


}
