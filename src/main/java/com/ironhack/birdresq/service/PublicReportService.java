package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.enums.BirdStatus;

import java.util.List;
import java.util.UUID;

public interface PublicReportService {

    List<PublicReportDto> getAllPublicReports();

    PublicReportDto getPublicReportById(UUID id);

    void updateBirdStatusAndProtection(UUID id, BirdStatus birdStatus, Boolean isProtected);

}
