package com.alexraza.usiu_job_board.service;

import com.alexraza.usiu_job_board.model.Application;
import com.alexraza.usiu_job_board.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application applyToJob(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJob_Id(jobId);
    }

    public List<Application> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByApplicant_Id(userId);
    }
}

