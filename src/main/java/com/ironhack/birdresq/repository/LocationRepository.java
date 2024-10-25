package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
