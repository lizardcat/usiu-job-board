package com.alexraza.usiu_job_board.repository;

import com.alexraza.usiu_job_board.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByLocation(String location);
    List<Job> findByType(String type);
    List<Job> findByPostedBy_Id(Long userId);
    List<Job> findByLocationAndType(String location, String type);
}
