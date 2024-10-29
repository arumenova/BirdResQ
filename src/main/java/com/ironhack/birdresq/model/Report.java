package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    @Lob
    @Column(nullable = true)
    private byte[] uploadImage;

    @NotBlank(message = "Species is required")
    private String species;

    @NotBlank(message = "Injury description is required")
    @Column(length = 500)
    private String injuryDescription;

    private Double latitude;
    private Double longitude;

    @NotBlank(message = "The address is required")
    private String address;

    private LocalDateTime reportDateTime;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "injured_bird_id")
    private InjuredBird injuredBird;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;


    public Report(String name, String email, String phoneNumber, byte[] uploadImage, String species,
                  String injuryDescription, Double latitude, Double longitude, String address,
                  LocalDateTime reportDateTime, ReportStatus reportStatus, User user, InjuredBird injuredBird, Admin admin) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.uploadImage = uploadImage;
        this.species = species;
        this.injuryDescription = injuryDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.reportDateTime = reportDateTime;
        this.reportStatus = reportStatus;
        this.user = user;
        this.injuredBird = injuredBird;
        this.admin = admin;
    }
}
