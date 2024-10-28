package com.ironhack.birdresq.controller;

import com.ironhack.birdresq.dto.UserDto;
import com.ironhack.birdresq.model.BasicUser;
import com.ironhack.birdresq.model.User;
import com.ironhack.birdresq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ironhack.birdresq.model.Admin;
import com.ironhack.birdresq.model.Volunteer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserDto userDTO) {
        BasicUser user = new BasicUser(userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNumber());

        userService.createUser(user);
        return user;
    }
}




