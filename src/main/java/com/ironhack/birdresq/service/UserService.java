package com.ironhack.birdresq.service;

import com.ironhack.birdresq.model.InjuredBird;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(User user);

    Report reportInjuredBird(Long userId, Report report);

    Report getReportStatusById(UUID id);

    List<Report> getReportsByUserId(Long id);


    //    This method give access to the users to see
//    all existing reports of injured birds and
//    this is a good approach, because shows transparency of the organisation
    List<Report> getAllReports();

    List<InjuredBird> getAllInjuredBirds();
}
