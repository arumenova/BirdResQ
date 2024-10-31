package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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


    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)  // Correct mapping to PublicReport
    private List<PublicReport> publicReports;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

//
//    @ManyToMany(mappedBy = "reports")
//    private Set<Volunteer> volunteers = new HashSet<>();


}
