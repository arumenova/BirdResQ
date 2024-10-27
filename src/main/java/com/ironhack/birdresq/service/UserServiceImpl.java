package com.ironhack.birdresq.service;

import com.ironhack.birdresq.model.InjuredBird;
import com.ironhack.birdresq.model.Report;
import com.ironhack.birdresq.model.User;
import com.ironhack.birdresq.repository.InjuredBirdRepository;
import com.ironhack.birdresq.repository.ReportRepository;
import com.ironhack.birdresq.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ReportRepository reportRepository;

    private InjuredBirdRepository injuredBirdRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Report reportInjuredBird(Long userId, Report report) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User User=user.get();
            report.setUser(User);
            report.setReportDateTime(LocalDateTime.now());
            return reportRepository.save(report);
        }
        return null;
    }



    @Override
    public Report getReportStatusById(UUID id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public List<Report> getReportsByUserId(Long id) {
        return reportRepository.findAllByUserId(id);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<InjuredBird> getAllInjuredBirds() {
        return injuredBirdRepository.findAll();
    }
}
