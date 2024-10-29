package com.ironhack.birdresq.dto;

import com.ironhack.birdresq.enums.ReportStatus;
import com.ironhack.birdresq.model.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PublicReportDto {

    private UUID id;
    private String species;
    private String injuryDescription;
    private ReportStatus reportStatus;
    private LocalDateTime localDateTime;


}
