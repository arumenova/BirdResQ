package com.ironhack.birdresq.repository;


import com.ironhack.birdresq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailIgnoreCase (String email);

    Optional<User> findByUsername(String username);
}
