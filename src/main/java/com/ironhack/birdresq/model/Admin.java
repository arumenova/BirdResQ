package com.ironhack.birdresq.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Data
public class Admin extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    @OneToMany(mappedBy = "admin")
    private Set<Report>adminReports=new HashSet<Report>();

    @OneToMany(mappedBy = "admin")
    private Set<Volunteer>volunteers=new HashSet<Volunteer>();

    public Admin(String name, String email, String phoneNumber, String password) {
        super(name, email, phoneNumber);
        this.password = password;
    }
}
