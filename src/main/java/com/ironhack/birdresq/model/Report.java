package com.ironhack.birdresq.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reportId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
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


    @NotBlank(message = "The address is required")
    private String address;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    private LocalDateTime reportDateTime;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    @ManyToMany(mappedBy = "volunteeredReports")
    @JsonIgnore
    private List<Volunteer> volunteers = new ArrayList<>();


    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
    private BirdStatusInfo birdStatusInfo;

}
