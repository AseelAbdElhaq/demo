package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostConstruct
    public void init() { 
    userRepository.save(new User("Aseel", 21));
    userRepository.save(new User("Deema", 21));
}
}