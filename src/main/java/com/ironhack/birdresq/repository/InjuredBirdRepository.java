package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.InjuredBird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InjuredBirdRepository extends JpaRepository<InjuredBird, Long> {
}
