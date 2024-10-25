package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
