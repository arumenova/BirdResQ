package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, UUID> {

    List<Report> findAllByUserId(Long userId);

    List<Report> findByAdminId(Long adminId);

    List<Report> findByReportStatus(ReportStatus reportStatus);

    List<Report> findByInjuredBirdId(Long injuredBirdId);


}
