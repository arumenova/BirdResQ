package com.ironhack.birdresq.repository;

import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserReports (Set<Report> userReports);

    List<User> findByEmail (String email);

}
