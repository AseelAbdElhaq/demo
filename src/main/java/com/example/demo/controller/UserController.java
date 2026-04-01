package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  GET all users 
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    //  admin only can create user
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    //  user can edit ONLY his own data
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,
                           @Valid @RequestBody User user,
                           @AuthenticationPrincipal UserDetails currentUser) {

        User existingUser = userService.getUserById(id);

        //  check if user authorized to edit  
        if (!existingUser.getUsername().equals(currentUser.getUsername())) {
            throw new RuntimeException("You can only edit your own data");
        }

        return userService.updateUser(id, user);
    }
}