package com.ironhack.birdresq.service;

import com.ironhack.birdresq.model.BirdStatusInfo;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.repository.BirdStatusInfoRepository;
import com.ironhack.birdresq.repository.ReportRepository;
import com.ironhack.birdresq.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BirdStatusInfoService {


    private final BirdStatusInfoRepository birdStatusInfoRepository;
    private final ReportRepository reportRepository;
    private final VolunteerRepository volunteerRepository;

    @Transactional
    public void volunteerUpdateBirdStatus(UUID reportId, BirdStatus newStatus, Long volunteerId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found with id: " + reportId));

        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found with id: " + volunteerId));

        if (!report.getVolunteers().contains(volunteer)) {
            throw new IllegalArgumentException("Volunteer is not associated with this report.");
        }

        BirdStatusInfo birdStatusInfo = report.getBirdStatusInfo();
        if (birdStatusInfo == null) {
            birdStatusInfo = new BirdStatusInfo();
            birdStatusInfo.setReport(report);
        }
        birdStatusInfo.setBirdStatus(newStatus);
        birdStatusInfoRepository.save(birdStatusInfo);
    }

    @Transactional
    public void updateIsProtected(UUID reportId, Boolean isProtected) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found with id: " + reportId));

        BirdStatusInfo birdStatusInfo = report.getBirdStatusInfo();
        if (birdStatusInfo == null) {
            birdStatusInfo = new BirdStatusInfo();
            birdStatusInfo.setReport(report);  // link the BirdStatusInfo to the Report
        }
        birdStatusInfo.setIsProtected(isProtected);
        birdStatusInfoRepository.save(birdStatusInfo);
    }
}

