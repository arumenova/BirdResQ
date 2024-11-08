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
import  com.ironhack.birdresq.enums.Role;
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

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Report> adminReports = new HashSet<Report>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers = new HashSet<Volunteer>();


    @Override
    public Collection<String> getRole() {

        return List.of("ADMIN");
    }


}
