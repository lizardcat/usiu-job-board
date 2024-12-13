package com.alexraza.usiu_job_board.repository;

import com.alexraza.usiu_job_board.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByJob_Id(Long jobId);
    List<Application> findByApplicant_Id(Long userId);
}

