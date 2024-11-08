package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.enums.Role;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public Volunteer createVolunteerAccount(VolunteerDto volunteerDto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setName(volunteerDto.getName());
        volunteer.setEmail(volunteerDto.getEmail());
        volunteer.setPhoneNumber(volunteerDto.getPhoneNumber());
        volunteer.setUsername(volunteerDto.getUsername());
        volunteer.setIsAvailable(volunteerDto.getIsAvailable());


        String hashedPassword = passwordEncoder.encode(volunteerDto.getPassword());
        volunteer.setPassword(hashedPassword);

        String roleString = volunteerDto.getRole();
        Role role = Role.valueOf(roleString.toUpperCase());
        volunteer.setRole(role);

        return volunteerRepository.save(volunteer);
    }



    @Override
    public Optional<Volunteer> updateVolunteerByEmail(String email, Volunteer updatedVolunteer) {
        Optional<Volunteer> existingVolunteerOpt = volunteerRepository.findByEmailIgnoreCase(email);

        if (existingVolunteerOpt.isPresent()) {
            Volunteer existingVolunteer = existingVolunteerOpt.get();
            existingVolunteer.setName(updatedVolunteer.getName());
            existingVolunteer.setEmail(updatedVolunteer.getEmail());
            existingVolunteer.setPhoneNumber(updatedVolunteer.getPhoneNumber());
            existingVolunteer.setUsername(updatedVolunteer.getUsername());
            existingVolunteer.setPassword(updatedVolunteer.getPassword());
            existingVolunteer.setIsAvailable(updatedVolunteer.getIsAvailable());
            return Optional.of(volunteerRepository.save(existingVolunteer));
        }
        return Optional.empty();
    }
}




