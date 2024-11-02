package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Volunteer;
import jakarta.validation.Valid;

import java.util.Optional;

public interface VolunteerService {

    Volunteer createVolunteerAccount(VolunteerDto volunteerDto);

    Optional<Volunteer> updateVolunteerByEmail(@Valid String email, Volunteer updatedVolunteer);
}
