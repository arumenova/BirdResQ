package com.ironhack.birdresq.service;
import com.ironhack.birdresq.model.User;
import com.ironhack.birdresq.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


}
