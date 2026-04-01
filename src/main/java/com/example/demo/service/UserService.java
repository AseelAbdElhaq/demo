package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    //  constructor injection 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //  get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    //  add new user if you are admin
    public User addUser(User user) {
        return userRepository.save(user);
    }
    //  get user by id or throw exception if not found 
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    //  update user if you are the owner of the account 
    public User updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);

        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());

        return userRepository.save(existingUser);
    }
}