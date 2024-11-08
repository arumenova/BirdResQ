package com.ironhack.birdresq.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private String username;
    private String password;

    // Constructor for User class with username and password (for Spring Security usage)
    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
    }

    // Abstract method for authorities
    public abstract Collection<? extends GrantedAuthority> getAuthorities();

    public abstract boolean isAccountNonExpired();

    public abstract boolean isAccountNonLocked();

    public abstract boolean isCredentialsNonExpired();

    public abstract boolean isEnabled();

    public abstract Collection<String> getRole();


}
