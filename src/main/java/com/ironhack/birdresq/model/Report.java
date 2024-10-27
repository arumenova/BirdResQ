package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime reportDateTime;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "injured_bird_id")
    private InjuredBird injuredBird;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;



    public Report(LocalDateTime reportDateTime, ReportStatus reportStatus, User user, InjuredBird injuredBird, Admin admin) {
        this.reportDateTime = reportDateTime;
        this.reportStatus = reportStatus;
        this.user = user;
        this.injuredBird = injuredBird;
        this.admin = admin;
    }
}
