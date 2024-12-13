package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.User;
import com.alexraza.usiu_job_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProfileController {

    private final UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/client/view-user")
    public String viewUser(@RequestParam Long userId, Model model) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
        } else {
            model.addAttribute("error", "User not found.");
        }
        return "profile"; // Points to profile.html in the templates folder
    }
}
