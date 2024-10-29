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

    private String species;

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

    public InjuredBird(String species, BirdStatus birdStatus, Boolean isProtected, User user, Set<Report> reports, Location location, Set<Volunteer> volunteers) {
        this.species = species;
        this.birdStatus = birdStatus;
        this.isProtected = isProtected;
        this.user = user;
        this.reports = reports;
        this.location = location;
        this.volunteers = volunteers;
    }
}
