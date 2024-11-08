package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.service.BirdStatusInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bird-status-info")
public class BirdStatusInfoController {

    @Autowired
    private BirdStatusInfoService birdStatusInfoService;

    @PutMapping("{reportId}/bird-status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBirdStatus(
            @PathVariable UUID reportId,
            @RequestParam BirdStatus birdStatus,
            @RequestParam Long volunteerId) {
        birdStatusInfoService.volunteerUpdateBirdStatus(reportId, birdStatus, volunteerId);
    }

    @PutMapping("{reportId}/is-protected")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIsProtected(@PathVariable UUID reportId, @RequestParam Boolean isProtected) {
        birdStatusInfoService.updateIsProtected(reportId, isProtected);
    }
}
