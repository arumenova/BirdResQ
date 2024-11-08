package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
   Optional<Admin> findByUsername(String username);  // Method to find Admin by username

   // Add this method to find by email ignoring case
   Optional<Admin> findByEmailIgnoreCase(String email);
}
