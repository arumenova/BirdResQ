package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
