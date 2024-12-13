package com.alexraza.usiu_job_board.service;

import com.alexraza.usiu_job_board.model.User;
import com.alexraza.usiu_job_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to get a user by their ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Method to get all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // New method to get User by Username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
