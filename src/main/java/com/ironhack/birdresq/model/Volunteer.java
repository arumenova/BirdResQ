package com.ironhack.birdresq.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
public class Volunteer extends User{



    private String password;
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany
    @JoinTable(
            name = "volunteer_bird",
            joinColumns = @JoinColumn(name="volunteer_id"),
            inverseJoinColumns = @JoinColumn(name="injured_bird_id")
    )
    private Set<InjuredBird>assignedBirds = new HashSet<>();

    public Volunteer(String name, String email, String phoneNumber, String password, Boolean availability) {
        super(name, email, phoneNumber);
        this.password = password;
        this.availability = availability;
    }
}
