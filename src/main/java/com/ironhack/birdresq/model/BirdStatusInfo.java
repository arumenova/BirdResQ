package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirdStatusInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private BirdStatus birdStatus;

    private Boolean isProtected;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "reportId")
    private Report report;
}

