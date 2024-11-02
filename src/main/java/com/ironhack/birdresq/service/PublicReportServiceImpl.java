package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.repository.ReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicReportServiceImpl implements PublicReportService {

    private final ReportRepository reportRepository;

    @Override
    public List<PublicReportDto> getAllPublicReports() {
        return reportRepository.findAll().stream()
                .map(this::mapToPublicReportDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublicReportDto getPublicReportById(UUID id) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report not found"));

        return mapToPublicReportDto(report);
    }

    @Override
    public void updateBirdStatusAndProtection(UUID id, BirdStatus birdStatus, Boolean isProtected) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Report not found"));


        report.setBirdStatus(birdStatus);
        report.setIsProtected(isProtected);

        reportRepository.save(report); // Save changes
    }

    private PublicReportDto mapToPublicReportDto(Report report) {
        return new PublicReportDto(
                report.getId(),
                report.getSpecies(),
                report.getInjuryDescription(),
                report.getReportStatus(),
                report.getReportDateTime(),
                report.getBirdStatus(),
                report.getIsProtected()
        );
    }
}


