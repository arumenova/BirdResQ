package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.PublicReportDto;
import com.ironhack.birdresq.dto.ReportDto;
import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.service.ReportService;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
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

    @PostMapping("/createReport")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createReport(@RequestBody ReportDto reportDto) {
        Report newReport = reportService.createReport(reportDto);
        return newReport.getId();
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReport (@PathVariable UUID id, @RequestBody ReportDto reportDto) {
        reportDto.setId(id);
        reportService.updateReport(reportDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Report getReport(@PathVariable UUID id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/public")
    @ResponseStatus(HttpStatus.OK)
    public List<PublicReportDto> getAllPublicReports() {
        return reportService.getPublicReports();
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReportStatus(@PathVariable UUID id, @RequestParam String reportStatus) {
        reportService.updateReportStatus(id, reportStatus);
    }
}
