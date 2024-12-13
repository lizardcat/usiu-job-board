package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.User;
import com.alexraza.usiu_job_board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private UserService userService; // Assuming a service to fetch users

    @GetMapping
    public String clientDashboard(Model model) {
        List<User> users = userService.getAllUsers(); // Fetch all users
        model.addAttribute("users", users);
        return "client"; // Points to client.html in the templates folder
    }
}
