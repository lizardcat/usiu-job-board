package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.Job;
import com.alexraza.usiu_job_board.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final JobService jobService;

    @Autowired
    public UserController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/user")
    public String userDashboard(Model model) {
        List<Job> jobs = jobService.getAllJobs(); // Fetch all jobs
        model.addAttribute("jobs", jobs);
        return "user"; // Points to user.html in the templates folder
    }
}
