package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.model.Report;

import java.util.List;
import java.util.UUID;

public interface ReportService {

    Report createReport(ReportDto reportDto);


    Report getReportById(UUID id);

    // This method is allowed only for admin
    List<Report> getAllReports();

    void updateReport(ReportDto reportDto);

    void updateReportStatus(UUID reportId, String newStatus,Long id);


    void volunteerUpdateBirdStatus(UUID reportId, BirdStatus newStatus, Long id);

    void assignVoluneerToReport(UUID reportId, Long id);

}
