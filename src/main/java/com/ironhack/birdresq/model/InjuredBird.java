package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
public class InjuredBird {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = true)
    private byte[] uploadImage;

    @NotBlank(message = "Species is required")
    private String species;

    @NotBlank(message = "Injury description is required")
    @Column(length = 500)
    private String injuryDescription;

    @Enumerated(EnumType.STRING)
    private BirdStatus birdStatus;

    private Boolean isProtected;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "injured_bird_id")
    private Set<Report> reports = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @ManyToMany(mappedBy = "assignedBirds")
    private Set<Volunteer> volunteers = new HashSet<>();


    public InjuredBird(String species, String injuryDescription, BirdStatus birdStatus, Boolean isProtected, byte[] uploadImage) {
        this.species = species;
        this.injuryDescription = injuryDescription;
        this.birdStatus = birdStatus;
        this.isProtected = isProtected;
        this.uploadImage = uploadImage;
    }
}
