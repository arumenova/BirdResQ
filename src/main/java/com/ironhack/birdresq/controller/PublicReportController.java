package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.service.PublicReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/public-reports")
@RequiredArgsConstructor
public class PublicReportController {

    private final PublicReportService publicReportService;

    @GetMapping
    public ResponseEntity<List<PublicReportDto>> getAllPublicReports() {
        List<PublicReportDto> publicReports = publicReportService.getAllPublicReports();
        return ResponseEntity.ok(publicReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicReportDto> getPublicReportById(@PathVariable UUID id) {
        PublicReportDto publicReport = publicReportService.getPublicReportById(id);
        return ResponseEntity.ok(publicReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBirdStatusAndProtection(
            @PathVariable UUID id,
            @RequestParam BirdStatus birdStatus,
            @RequestParam Boolean isProtected) {
        publicReportService.updateBirdStatusAndProtection(id, birdStatus, isProtected);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
