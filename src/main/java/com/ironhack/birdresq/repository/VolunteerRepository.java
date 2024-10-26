package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findByNameIgnoreCase(String name);

    List<Volunteer> findByEmailIgnoreCase(String email);

    List<Volunteer> findByAvailability(Boolean availability);
}
