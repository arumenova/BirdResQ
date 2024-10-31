package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.model.PublicReport;
import com.ironhack.birdresq.repository.PublicReportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicReportServiceImpl implements PublicReportService {

    private final PublicReportRepository publicReportRepository;

    @Override
    public List<PublicReportDto> getAllPublicReports() {
        return publicReportRepository.findAll().stream()
                .map(publicReport -> new PublicReportDto(
                        publicReport.getReport().getId(), // Get the original report's ID
                        publicReport.getReport().getSpecies(), // Access species from Report
                        publicReport.getReport().getInjuryDescription(), // Access injury description from Report
                        publicReport.getReport().getReportStatus(), // Access status from Report
                        publicReport.getReport().getReportDateTime(), // Access date from Report
                        publicReport.getBirdStatus(),
                        publicReport.getIsProtected()
                )).collect(Collectors.toList());
    }

    @Override
    public PublicReportDto getPublicReportById(UUID id) {
        PublicReport publicReport = publicReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Public report not found"));

        return new PublicReportDto(
                publicReport.getReport().getId(), // Get the original report's ID
                publicReport.getReport().getSpecies(), // Access species from Report
                publicReport.getReport().getInjuryDescription(), // Access injury description from Report
                publicReport.getReport().getReportStatus(), // Access status from Report
                publicReport.getReport().getReportDateTime(), // Access date from Report
                publicReport.getBirdStatus(),
                publicReport.getIsProtected()
        );
    }

    @Override
    public void updateBirdStatusAndProtection(UUID id, BirdStatus birdStatus, Boolean isProtected) {
        PublicReport publicReport = publicReportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Public report not found"));

        publicReport.setBirdStatus(birdStatus);
        publicReport.setIsProtected(isProtected);
        publicReportRepository.save(publicReport); // Save changes to PublicReport
    }
}
