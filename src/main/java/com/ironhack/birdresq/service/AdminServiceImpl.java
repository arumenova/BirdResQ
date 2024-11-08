package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.enums.Role;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createAdminAccount(AdminDto adminDto) {

        Role role = Role.fromString(adminDto.getRole());

        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setUsername(adminDto.getUsername());

        String hashedPassword = passwordEncoder.encode(adminDto.getPassword());
        admin.setPassword(hashedPassword);

        admin.setRole(role);

        return adminRepository.save(admin);
    }



    @Override
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
