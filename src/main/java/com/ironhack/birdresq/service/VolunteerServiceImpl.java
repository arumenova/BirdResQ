package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;

    @Override
    public Volunteer createVolunteerAccount(VolunteerDto volunteerDto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setName(volunteerDto.getName());
        volunteer.setEmail(volunteerDto.getEmail());
        volunteer.setPassword(volunteerDto.getPassword());
        volunteer.setPhoneNumber(volunteerDto.getPhoneNumber());
        volunteer.setUsername(volunteerDto.getUsername());
        volunteer.setPassword(volunteerDto.getPassword());
        volunteer.setAvailability(volunteerDto.getIsAvailable());
        return volunteerRepository.save(volunteer);
    }
}
