package com.youtube.user_api.controllers;

import com.youtube.user_api.dto.UserRegistrationDTO;
import com.youtube.user_api.models.User;
import com.youtube.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * This is the user registration endpoint now if a user wants to register himself
     * So, His request is going to come over this method only.
     * And this method will save user details inside the user table.
     * @param userRegistrationDTO
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        // To Register user we should call user service
        User user = userService.registerUser(userRegistrationDTO);
        return user;
    }

}
