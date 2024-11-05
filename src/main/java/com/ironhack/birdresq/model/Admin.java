package com.ironhack.birdresq.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin extends User {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Report> adminReports = new HashSet<Report>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers = new HashSet<Volunteer>();


}
