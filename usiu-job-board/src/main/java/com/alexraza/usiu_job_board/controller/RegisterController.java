package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.User;
import com.alexraza.usiu_job_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Display the registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Points to register.html in the templates folder
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userRepository.findByUsername(user.getFullName()).isPresent()) {
            model.addAttribute("error", "Username already taken. Please choose another.");
            return "register";
        }

        // Save the new user to the database
        userRepository.save(user);
        model.addAttribute("success", "Registration successful! You can now login.");
        return "redirect:/login";
    }
}
