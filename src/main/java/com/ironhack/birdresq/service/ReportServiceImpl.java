package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public Report createReport(ReportDto reportDto) {
        return null;
    }

    @Override
    public Report updateReport(ReportDto reportDto) {
        return null;
    }

    @Override
    public Report getReportById(UUID id) {
        return null;
    }

    @Override
    public List<Report> getAllReports() {
        return List.of();
    }

    @Override
    public List<Report> getPublicReports() {
        return List.of();
    }

    @Override
    public void updateReportStatus(UUID id, String newStatus) {

    }
}
