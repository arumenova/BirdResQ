package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Volunteer;

public interface VolunteerService {

    Volunteer createVolunteerAccount(VolunteerDto volunteerDto);
}
