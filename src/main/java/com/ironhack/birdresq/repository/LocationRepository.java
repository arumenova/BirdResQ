package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByAddress(String address);

// Method used to calculate the distance between two geographical points.
// It is used Haversine formula to calculate the great-circle distance
// between two points on the Earth.
    @Query(value = "SELECT *, " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(latitude)) * " +
            "cos(radians(longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(latitude)))) AS distance " +
            "FROM location " +
            "HAVING distance < :distance " +
            "ORDER BY distance",
            nativeQuery = true)
    List<Location> findLocationsNear(@Param("latitude") Double latitude,
                                     @Param("longitude") Double longitude,
                                     @Param("distance") Double distance);
}

