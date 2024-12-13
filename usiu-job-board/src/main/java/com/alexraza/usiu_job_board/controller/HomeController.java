package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.Job;
import com.alexraza.usiu_job_board.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final JobService jobService;

    @Autowired
    public HomeController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Job> jobs = jobService.getAllJobs(); // Assuming `jobService` fetches from the database
        model.addAttribute("jobs", jobs);
        return "home"; // Return the `home.html` page
    }
}
