package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.BirdStatusInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BirdStatusInfoRepository extends JpaRepository<BirdStatusInfo, UUID> {
}
