package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findByNameIgnoreCase(String name);
    List<Volunteer> findByIsAvailable(Boolean isAvailable);
    Optional<Volunteer> findByEmailIgnoreCase(String email);
}
