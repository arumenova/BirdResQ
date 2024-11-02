package com.ironhack.birdresq.controller;


import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.BirdStatus;

import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.service.ReportService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/reports")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createReport(@RequestBody @Valid ReportDto reportDto) {
        Report newReport = reportService.createReport(reportDto);
        return newReport.getReportId();
    }
// Important: this should be allowed only for admin
    @PostMapping("/{reportId}/assign-volunteer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignVolunteer(@PathVariable UUID reportId, @PathVariable Long id) {
        reportService.assignVolunteerToReport(reportId,id);
    }

    @PutMapping("/{reportId}/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReport (@PathVariable UUID reportId, @RequestBody ReportDto reportDto) {
        reportDto.setReportId(reportId);
        reportService.updateReport(reportDto);
    }

    @GetMapping("/{reportId}")
    @ResponseStatus(HttpStatus.OK)
    public Report getReport(@PathVariable UUID reportId) {
        return reportService.getReportById(reportId);
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }


    @PutMapping("/{reportId}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReportStatus(@PathVariable UUID reportId, @RequestParam String reportStatus, @RequestParam Long id) {
        reportService.updateReportStatus(reportId, reportStatus, id);
    }
    @PutMapping("{reportId}/bird-status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBirdStatus(
            @PathVariable UUID reportId,
            @RequestParam BirdStatus birdStatus,
            @RequestParam Long id) {
        reportService.volunteerUpdateBirdStatus(reportId, birdStatus,id);
    }

    @PutMapping("{reportId}/is-protected")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIsProtected(@PathVariable UUID reportId, @RequestParam Boolean isProtected) {
        reportService.updateIsProtected(reportId,isProtected);
    }

    @DeleteMapping("{reportId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable UUID reportId) {
        reportService.deleteReport(reportId);
    }


}
