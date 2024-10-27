package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.enums.BirdStatus;
import com.ironhack.birdresq.model.InjuredBird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InjuredBirdRepository extends JpaRepository<InjuredBird, Long> {

    List<InjuredBird> findAllById(Long id);

    List<InjuredBird> findBySpecies(String species);

    List<InjuredBird> findByBirdStatus(BirdStatus status);

    List<InjuredBird> findByIsProtected(Boolean isProtected);
}
