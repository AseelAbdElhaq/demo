package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get method for retrive all users 
    @GetMapping
    public List<user> getUsers() {
        return userService.getAllUsers();
    }
}