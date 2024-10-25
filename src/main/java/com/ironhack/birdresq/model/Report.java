package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime reportDateTime;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    public Report(LocalDateTime reportDateTime, ReportStatus reportStatus) {
        this.reportDateTime = reportDateTime;
        this.reportStatus = reportStatus;
    }
}
