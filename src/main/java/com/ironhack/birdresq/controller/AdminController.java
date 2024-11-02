package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create-account")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Admin> createAdminAccount(@Valid @RequestBody AdminDto adminDto) {
        Admin createdAdmin = adminService.createAdminAccount(adminDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }
    @PutMapping("/{email}")
    public ResponseEntity<String> updateAdmin(@Valid @PathVariable String email, @RequestBody Admin updatedAdmin) {
        Optional<Admin> updatedAdminOpt = adminService.updateAdminAccountByEmail(email, updatedAdmin);

        if (updatedAdminOpt.isPresent()) {

            Admin updatedAdminAccount = updatedAdminOpt.get();
            return ResponseEntity.ok("Admin account updated successfully: " + updatedAdminAccount);
        } else {

            return ResponseEntity.status(404).body("Admin not found with email: " + email);
        }
    }
}
