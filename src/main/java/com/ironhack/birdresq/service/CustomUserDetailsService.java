package com.ironhack.birdresq.service;

import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.model.Volunteer;
import com.ironhack.birdresq.repository.AdminRepository;
import com.ironhack.birdresq.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        Volunteer volunteer = volunteerRepository.findByUsername(username);

        if (admin != null) {
            return new CustomUserDetails(admin.getUsername(), admin.getPassword(), admin.getAuthorities());
        } else if (volunteer != null) {
            return new CustomUserDetails(volunteer.getUsername(), volunteer.getPassword(), volunteer.getAuthorities());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
