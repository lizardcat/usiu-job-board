package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.Job;
import com.alexraza.usiu_job_board.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Endpoint to show the jobs page
    @GetMapping
    public String jobsPage(Model model) {
        List<Job> jobs = jobService.getAllJobs(); // Using jobService to fetch all jobs
        model.addAttribute("jobs", jobs);
        return "jobs"; // This points to the jobs.html in the templates folder
    }

    @PostMapping("/add")
    public String addJob(@ModelAttribute Job job) {
        jobService.createJob(job);
        return "redirect:/jobs"; // Redirect to jobs page after adding a job
    }

}
