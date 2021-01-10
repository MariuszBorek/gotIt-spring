package com.gotit.controller;

import com.gotit.dto.UserDTO;
import com.gotit.dto.MessageDTO;
import com.gotit.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
