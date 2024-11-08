package com.ironhack.birdresq.dto;

import com.ironhack.birdresq.enums.BirdStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BirdStatusInfoDto {
    private BirdStatus birdStatus;
    private Boolean isProtected;
}