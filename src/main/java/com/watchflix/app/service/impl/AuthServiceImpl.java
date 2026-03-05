package com.watchflix.app.service.impl;

import com.watchflix.app.domain.LoginRequest;
import com.watchflix.app.domain.RegisterRequest;
import com.watchflix.app.domain.entity.User;
import com.watchflix.app.exception.DuplicateUserException;
import com.watchflix.app.exception.UserNotFoundException;
import com.watchflix.app.repository.UserRepository;
import com.watchflix.app.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String login(LoginRequest request) {
        return "";
    }

    @Override
    public String register(RegisterRequest request){

        Instant now = Instant.now();
        boolean doesUserExist = userRepository.existsByUsername(request.username());

        if(doesUserExist){
           throw new DuplicateUserException(request.username());
        }
    // create a user
        User user = new User(
                null,
                request.username(),
                request.password(),
                now,
                now
        );

        User savedUser = userRepository.save(user);

        return " ";


    }
}
