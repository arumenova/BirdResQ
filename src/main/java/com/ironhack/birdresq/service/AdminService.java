package com.ironhack.birdresq.service;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;

public interface AdminService {

    Admin createAdminAccount(AdminDto adminDto);
}
