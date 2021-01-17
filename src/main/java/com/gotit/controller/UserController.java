package com.gotit.controller;

import com.gotit.dto.AuctionDTO;
import com.gotit.dto.UserDTO;
import com.gotit.dto.MessageDTO;
import com.gotit.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @GetMapping(path = "/watched-auctions/{email}", produces = "application/json")
    public List<AuctionDTO> getWatchedAuctions(@PathVariable("email") final String email) {
        return userService.findWatchedAuctions(email);
    }

}
