package com.ironhack.birdresq.model;

import com.ironhack.birdresq.enums.BirdStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicReport {


    private UUID id;
    private BirdStatus birdStatus;
    private Boolean isProtected;
    private Report report;
}
