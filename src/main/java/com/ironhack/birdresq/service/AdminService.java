package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;

import java.util.Optional;

public interface AdminService {

    Admin createAdminAccount(AdminDto adminDto);

    Optional<Admin> updateAdminAccountByEmail(String email, Admin updatedAdmin);
}
