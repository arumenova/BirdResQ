package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.service.VolunteerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/volunteer")
@RequiredArgsConstructor
public class VolunteerController {

    private final VolunteerService volunteerService;

    @PostMapping("/create-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Volunteer createVolunteerAccount(@Valid @RequestBody VolunteerDto volunteerDto) {
        return volunteerService.createVolunteerAccount(volunteerDto);
    }
}
