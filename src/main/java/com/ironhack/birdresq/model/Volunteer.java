package com.ironhack.birdresq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Volunteer extends User {


    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    private Boolean isAvailable;


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;


    @ManyToMany
    @JoinTable(
            name = "volunteer_report",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "report_id")
    )
    private List<Report> volunteeredReports = new ArrayList<>();


}

