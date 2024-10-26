package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
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

    @Column(length = 500)
    private String injuryDescription;

    @Enumerated(EnumType.STRING)
    private BirdStatus birdStatus;
    private Boolean isProtected;

    @Lob
    @Column(nullable = true)
    private byte [] uploadImage;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="injured_bird_id")
    private Report report;

    @OneToOne
    @JoinColumn(name="location_id")
    private Location location;



    @ManyToMany(mappedBy = "assignedBirds")
    private Set<Volunteer>volunteers=new HashSet<>();



    public InjuredBird(String species, String injuryDescription, BirdStatus birdStatus, Boolean isProtected, byte[] uploadImage) {
        this.species = species;
        this.injuryDescription = injuryDescription;
        this.birdStatus = birdStatus;
        this.isProtected = isProtected;
        this.uploadImage = uploadImage;
    }
}
