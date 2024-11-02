package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.repository.AdminRepository;
import com.ironhack.birdresq.repository.VolunteerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final VolunteerRepository volunteerRepository;



    public Admin createAdminAccount(AdminDto adminDto) {

        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        return adminRepository.save(admin);
    }



    @Transactional
    public Optional<Admin> updateAdminAccountByEmail(String email, Admin updatedAdmin) {
        Optional<Admin> existingAdminOpt = adminRepository.findByEmailIgnoreCase(email);

        if (existingAdminOpt.isPresent()) {
            Admin existingAdmin = existingAdminOpt.get();
            existingAdmin.setName(updatedAdmin.getName());
            existingAdmin.setEmail(updatedAdmin.getEmail());
            existingAdmin.setPhoneNumber(updatedAdmin.getPhoneNumber());
            existingAdmin.setUsername(updatedAdmin.getUsername());
            existingAdmin.setPassword(updatedAdmin.getPassword());
            return Optional.of(adminRepository.save(existingAdmin));
        }

        return Optional.empty();
    }


}



