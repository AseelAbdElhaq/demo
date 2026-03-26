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
        users.add(new user(3, "Lina", 19));
        users.add(new user(4, "Omar", 25));
        users.add(new user(5, "Yousef", 23));
        users.add(new user(6, "Maya", 21));
        users.add(new user(7, "Ahmad", 24));
        users.add(new user(8, "Sara", 22));
        users.add(new user(9, "Kareem", 26));
        users.add(new user(10, "Noor", 18));
    }

    public List<user> getAllUsers() {
        return users;
    }
}