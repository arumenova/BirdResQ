package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.service.VolunteerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @PutMapping("/{email}")
    public ResponseEntity<String> updateVolunteer(
            @Valid @PathVariable String email,
            @RequestBody Volunteer updatedVolunteer) {

        Optional<Volunteer> updatedVolunteerOpt = volunteerService.updateVolunteerByEmail(email, updatedVolunteer);

        if (updatedVolunteerOpt.isPresent()) {
            Volunteer updatedVolunteerAccount = updatedVolunteerOpt.get();
            return ResponseEntity.ok("Volunteer account updated successfully: " + updatedVolunteerAccount);
        } else {
            return ResponseEntity.status(404).body("Volunteer not found with ID: " + email);
        }
    }
}
