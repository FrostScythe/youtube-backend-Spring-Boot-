package com.youtube.db_api.controllers;

import com.youtube.db_api.models.User;
import com.youtube.db_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class UserController {

    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id){
        userRepository.deleteById(id);
        return;
    }
}
