package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findByEmail(String email);
}
