package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl  implements AdminService {

    private final AdminRepository adminRepository;

    public Admin createAdminAccount(AdminDto adminDto) {

        Admin admin=new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        return adminRepository.save(admin);
    }
}
