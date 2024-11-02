package com.ironhack.birdresq.dto;

import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicReportDto {

    private UUID reportId;
    private String species;
    private String injuryDescription;
    private ReportStatus reportStatus;
    private LocalDateTime reportDateTime;
    private BirdStatus birdStatus;
    private Boolean isProtected;


}
