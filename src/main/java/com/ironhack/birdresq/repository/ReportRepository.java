package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
