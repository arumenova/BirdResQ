package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    public InjuredBird(String species, String injuryDescription, BirdStatus birdStatus, Boolean isProtected, byte[] uploadImage) {
        this.species = species;
        this.injuryDescription = injuryDescription;
        this.birdStatus = birdStatus;
        this.isProtected = isProtected;
        this.uploadImage = uploadImage;
    }
}
