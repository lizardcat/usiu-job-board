package com.alexraza.usiu_job_board.controller;

import com.alexraza.usiu_job_board.model.Application;
import com.alexraza.usiu_job_board.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application applyToJob(@RequestBody Application application) {
        return applicationService.applyToJob(application);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getApplicationsByJobId(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJobId(jobId);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUserId(@PathVariable Long userId) {
        return applicationService.getApplicationsByUserId(userId);
    }
}
