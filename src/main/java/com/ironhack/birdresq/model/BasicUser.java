package com.ironhack.birdresq.model;

import com.ironhack.birdresq.model.User;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class BasicUser extends User {



    public BasicUser(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);

    }


}

