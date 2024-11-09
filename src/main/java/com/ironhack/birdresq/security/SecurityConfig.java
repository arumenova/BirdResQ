package com.ironhack.birdresq.security;

import com.ironhack.birdresq.security.filters.CustomAuthenticationFilter;
import com.ironhack.birdresq.security.filters.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

        // Initialize the custom authentication filter with the custom login endpoint
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");

        // Configure HttpSecurity
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF as we're using stateless tokens
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))  // Stateless session management
                .authorizeHttpRequests(authorize -> authorize
                        // Permit access to public endpoints
//                        .requestMatchers(POST, "/api/report/reports").permitAll()
//                        .requestMatchers(POST, "/api/admin/create-account").permitAll()
//                        .requestMatchers(POST, "/api/login").permitAll()
//                        .requestMatchers(PUT, "/api/report/{reportId}/update").permitAll()
//
//                        // Role-based access control
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/volunteer/**").hasRole("VOLUNTEER")
//                        .requestMatchers(GET, "/api/reports/**").hasAnyAuthority("ADMIN", "VOLUNTEER")
//                        .requestMatchers(POST, "/api/reports/**").hasRole("ADMIN")
//                        .requestMatchers(PUT, "/api/reports/{id}/bird-status").hasRole("VOLUNTEER")
//                        .requestMatchers(PUT, "/api/reports/{id}/is-protected").hasRole("ADMIN")
//                        .requestMatchers(POST, "/api/reports/{reportId}/assign-volunteer/{id}").hasRole("ADMIN")

                        // Require authentication for all other requests
                        //.anyRequest().authenticated()
                                .anyRequest().permitAll()
                );

        // Add the authentication filter after setting up the authorization configuration
        http.addFilter(customAuthenticationFilter);

        // Add the authorization filter to validate JWTs before processing other filters
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
