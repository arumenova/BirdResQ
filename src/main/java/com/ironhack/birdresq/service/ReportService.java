package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;

import java.util.List;
import java.util.UUID;

public interface ReportService {

    Report createReport(ReportDto reportDto);

    Report updateReport(ReportDto reportDto);

    Report getReportById(UUID id);

// This method is allowed only for admin
    List<Report> getAllReports();


    void updateReportStatus(UUID id, String newStatus);

}
