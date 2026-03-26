package com.example.demo.service;

import com.example.demo.model.user;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<user> users = new ArrayList<>();

    public UserService() {
        // Dummy data
        users.add(new user(1, "Aseel", 22));
        users.add(new user(2, "Deema", 20));
    }

    public List<user> getAllUsers() {
        return users;
    }
}