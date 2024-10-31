package com.ironhack.birdresq.model;

import com.ironhack.birdresq.model.User;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class BasicUser extends User {


    public BasicUser(Long id, @NotBlank(message = "Name is required") String name, @Email(message = "Email should be valid") String email,
                     @NotBlank(message = "Phone number is required") String phoneNumber, List<Report> reports) {
        super(id, name, email, phoneNumber, reports);
    }
}

