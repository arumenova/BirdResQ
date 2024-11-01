package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdminAccount(@Valid @RequestBody AdminDto adminDto) {
        return adminService.createAdminAccount(adminDto);
    }
}
