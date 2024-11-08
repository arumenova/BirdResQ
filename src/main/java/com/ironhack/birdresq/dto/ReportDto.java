package com.ironhack.birdresq.dto;

import java.util.UUID;

import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    private UUID reportId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private byte[] uploadImage;

    @NotBlank(message = "Species is required")
    private String species;

    @NotBlank(message = "Injury description is required")
    private String injuryDescription;

    private ReportStatus reportStatus;

    private LocalDateTime reportDateTime;


    @NotBlank(message = "Address is required")
    private String address;



}
