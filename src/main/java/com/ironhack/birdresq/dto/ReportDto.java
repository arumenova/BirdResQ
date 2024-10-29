package com.ironhack.birdresq.dto;

import java.util.UUID;

import com.ironhack.birdresq.enums.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private UUID id;

    private String name;
    private String email;
    private String phone;

    private byte[] uploadImage;
    private String species;
    private String injuryDescription;
    private ReportStatus reportStatus;

    private LocalDateTime reportDateTime;

    private Double latitude;
    private Double longitude;
    private String address;

}
