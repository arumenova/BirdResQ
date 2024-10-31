package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private BirdStatus birdStatus;

    private Boolean isProtected;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}
