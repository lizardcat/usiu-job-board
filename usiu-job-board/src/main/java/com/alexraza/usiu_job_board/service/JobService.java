package com.alexraza.usiu_job_board.service;

import com.alexraza.usiu_job_board.model.Job;
import com.alexraza.usiu_job_board.model.User;
import com.alexraza.usiu_job_board.repository.JobRepository;
import com.alexraza.usiu_job_board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;

    @Autowired
    public JobService(JobRepository jobRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    // Get all jobs from the database
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Filter jobs by location and type
    public List<Job> filterJobs(String location, String type) {
        return jobRepository.findByLocationAndType(location, type);
    }

    // Create a new job posting
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Create a new job by a specific client
    public Job createJobForClient(Job job, String clientUsername) {
        // Find client user by username
        User client = userRepository.findByUsername(clientUsername)
                .orElseThrow(() -> new IllegalArgumentException("Client not found: " + clientUsername));
        job.setPostedBy(client);
        return jobRepository.save(job);
    }

    // Apply to a specific job by the current user
    public void applyToJob(Long jobId, String username) {
        // Find the job by ID
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found: " + jobId));

        // Find the user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));

        // Here, you would link the user to the job application.
        // For now, this can just be a simple message for testing or adding the logic for a JobApplication entity.
        System.out.println("User " + user.getUsername() + " applied for job " + job.getTitle());
        // You can create and save a JobApplication entity linking job and user
    }
}
