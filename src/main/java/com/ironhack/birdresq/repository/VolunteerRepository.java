package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByUsername(String username);  // Method to find Volunteer by username

    // Add this method to find Volunteer by email, ignoring case
    Optional<Volunteer> findByEmailIgnoreCase(String email);
}
