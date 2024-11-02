package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

   Optional <Admin> findByEmailIgnoreCase(String email);




}
