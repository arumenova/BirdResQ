package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.repository.ReportRepository;
import com.ironhack.birdresq.repository.VolunteerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final VolunteerRepository volunteerRepository;

    @Transactional
    @Override
    public Report createReport(ReportDto reportDto) {
        Report report = new Report();
        report.setReportId(UUID.randomUUID());
        report.setName(reportDto.getName());
        report.setEmail(reportDto.getEmail());
        report.setPhoneNumber(reportDto.getPhoneNumber());
        report.setUploadImage(reportDto.getUploadImage());
        report.setSpecies(reportDto.getSpecies());
        report.setInjuryDescription(reportDto.getInjuryDescription());
        report.setAddress(reportDto.getAddress());
        report.setReportDateTime(reportDto.getReportDateTime() != null ? reportDto.getReportDateTime() : LocalDateTime.now());

        return reportRepository.save(report);
    }

    @Override
    public void updateReport(ReportDto reportDto) {
        Report updatedReport = reportRepository.findById(reportDto.getReportId()).orElse(null);
        updatedReport.setName(reportDto.getName());
        updatedReport.setEmail(reportDto.getEmail());
        updatedReport.setPhoneNumber(reportDto.getPhoneNumber());
        updatedReport.setUploadImage(reportDto.getUploadImage());
        updatedReport.setSpecies(reportDto.getSpecies());
        updatedReport.setInjuryDescription(reportDto.getInjuryDescription());
        updatedReport.setAddress(reportDto.getAddress());
        updatedReport.setReportDateTime(reportDto.getReportDateTime());
        reportRepository.save(updatedReport);

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


    // The method checks first whether report is present,
//    if the report is present admin will  be able to update reportStatus
    // then I need to convert newStatus from String to enum Status
    @Override
    public void updateReportStatus(UUID reportId, String newStatus, Long id) {
        Optional<Report> report = reportRepository.findById(reportId);

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
            throw new EntityNotFoundException("Report with Id " + reportId + " not found");
        }
    }



    @Override
    public void assignVolunteerToReport(UUID reportId, Long id) {
        Optional<Report> reportOptional = reportRepository.findById(reportId);
        Optional<Volunteer> volunteerOptional = volunteerRepository.findById(id);

        if (reportOptional.isPresent() && volunteerOptional.isPresent()) {
            Report report = reportOptional.get();
            Volunteer volunteer = volunteerOptional.get();
            report.getVolunteers().add(volunteer);
            reportRepository.save(report);
        } else {
            throw new EntityNotFoundException("Report or Volunteer not found");
        }
    }


    @Override
    public void deleteReport(UUID reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        if (report.isPresent()) {
            reportRepository.delete(report.get());

        } else {
            throw new EntityNotFoundException("Report not found");
        }

    }
}





