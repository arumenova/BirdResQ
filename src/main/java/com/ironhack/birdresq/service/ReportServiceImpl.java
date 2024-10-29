package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.repository.ReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public Report createReport(ReportDto reportDto) {
        Report report = new Report();
        report.setId(UUID.randomUUID());
        report.setName(reportDto.getName());
        report.setEmail(reportDto.getEmail());
        report.setPhoneNumber(reportDto.getPhone());
        report.setUploadImage(reportDto.getUploadImage());
        report.setSpecies(reportDto.getSpecies());
        report.setInjuryDescription(reportDto.getInjuryDescription());
        report.setLatitude(reportDto.getLatitude());
        report.setLongitude(reportDto.getLongitude());
        report.setAddress(reportDto.getAddress());
        report.setReportDateTime(reportDto.getReportDateTime());

        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(ReportDto reportDto) {
        Report updatedReport = reportRepository.findById(reportDto.getId()).orElse(null);
        updatedReport.setName(reportDto.getName());
        updatedReport.setEmail(reportDto.getEmail());
        updatedReport.setPhoneNumber(reportDto.getPhone());
        updatedReport.setUploadImage(reportDto.getUploadImage());
        updatedReport.setSpecies(reportDto.getSpecies());
        updatedReport.setInjuryDescription(reportDto.getInjuryDescription());
        updatedReport.setLatitude(reportDto.getLatitude());
        updatedReport.setLongitude(reportDto.getLongitude());
        updatedReport.setAddress(reportDto.getAddress());
        updatedReport.setReportDateTime(reportDto.getReportDateTime());
        return reportRepository.save(updatedReport);

    }

    @Override
    public Report getReportById(UUID id) {
        return reportRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Report not found"));
    }

    // This method is available only for admin
    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<PublicReportDto> getPublicReports() {
        List<Report> reports = reportRepository.findAll();
        return reports.stream().map(report -> new PublicReportDto(
                report.getId(),
                report.getInjuredBird().getSpecies(),
                report.getInjuryDescription(),
                report.getReportStatus(),
                report.getReportDateTime()
        )).collect(Collectors.toList());

    }
// The method checks first whether report is present,
//    if the report is present admin will  be able to update reportStatus
    // then I needed to convert newStatus from String to enum Status
    @Override
    public void updateReportStatus(UUID id, String newStatus) {
        Optional<Report> report = reportRepository.findById(id);

        if (report.isPresent()) {
            Report updatedReportStatus = report.get();

            try {
                ReportStatus statusEnum = ReportStatus.valueOf(newStatus);
                updatedReportStatus.setReportStatus(statusEnum);
                reportRepository.save(updatedReportStatus);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid report status" + newStatus);
            }
        } else {
            throw new EntityNotFoundException("Report with Id " + id + " not found");
        }
    }

}

