package com.ironhack.birdresq.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin extends User {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Report> adminReports = new HashSet<Report>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers = new HashSet<Volunteer>();


}
