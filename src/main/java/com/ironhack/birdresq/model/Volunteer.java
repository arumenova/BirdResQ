package com.ironhack.birdresq.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Volunteer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private Boolean availability;

    public Volunteer(String name, String email, String phoneNumber, String password, Boolean availability) {
        super(name, email, phoneNumber);
        this.password = password;
        this.availability = availability;
    }
}
