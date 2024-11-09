package com.ironhack.birdresq.demo;

import com.ironhack.birdresq.dto.AdminDto;
import com.ironhack.birdresq.dto.VolunteerDto;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.model.Role;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.service.AdminService;
import com.ironhack.birdresq.service.ReportService;
import com.ironhack.birdresq.service.UserService;
import com.ironhack.birdresq.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final VolunteerService volunteerService;
    private final AdminService adminService;

    private UserService userService;



    @Override
    public void run(String... args) throws Exception {
        // Create Admin Accounts
        AdminDto adminDto = new AdminDto();
        adminDto.setName("Adriana Yordanova");
        adminDto.setEmail("admin@example.com");
        adminDto.setPhoneNumber("123456789");
        adminDto.setUsername("arg456");
        adminDto.setPassword("45155?");
        adminDto.setRole("ADMIN");
        adminService.createAdminAccount(adminDto);

//        // Create Volunteer Accounts with roles
//        VolunteerDto volunteerDto1 = new VolunteerDto();
//        volunteerDto1.setName("John Doe");
//        volunteerDto1.setEmail("john@example.com");
//        volunteerDto1.setPassword("1234");
//        volunteerDto1.setPhoneNumber("1234567890");
//        volunteerDto1.setUsername("john");
//        volunteerDto1.setIsAvailable(true);
//        volunteerDto1.setRole("VOLUNTEER");
//
//        VolunteerDto volunteerDto2 = new VolunteerDto();
//        volunteerDto2.setName("Jane Smith");
//        volunteerDto2.setEmail("jane@example.com");
//        volunteerDto2.setPassword("1234");
//        volunteerDto2.setPhoneNumber("0987654321");
//        volunteerDto2.setUsername("jane");
//        volunteerDto2.setIsAvailable(true);
//        volunteerDto2.setRole("VOLUNTEER");
//
//        volunteerService.createVolunteerAccount(volunteerDto1);
//        volunteerService.createVolunteerAccount(volunteerDto2);
    }
}
