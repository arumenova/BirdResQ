package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findByNameIgnoreCase(String name);

    List<Volunteer> findByEmailIgnoreCase(String email);

    List<Volunteer> findByAvailability(Boolean availability);
}
