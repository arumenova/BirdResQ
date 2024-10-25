package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
