package com.watchflix.app.controller;

import com.watchflix.app.domain.LoginRequest;
import com.watchflix.app.domain.RegisterRequest;
import com.watchflix.app.domain.dto.request.LoginRequestDto;
import com.watchflix.app.domain.dto.request.RegisterRequestDto;
import com.watchflix.app.domain.dto.response.AuthResponseDto;
import com.watchflix.app.domain.dto.response.UserDto;
import com.watchflix.app.mapper.UserMapper;
import com.watchflix.app.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.jaas.LoginExceptionResolver;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/v1/auth")

public class AuthController {

    private final UserMapper mapper;
    private final AuthService authService;
    public AuthController(UserMapper mapper, AuthService authService )
    {
        this.mapper = mapper;
        this.authService = authService;
    }

     @PostMapping(path = "/register")
     public ResponseEntity<AuthResponseDto> register(
                @Valid @RequestBody RegisterRequestDto dto)
     {
        RegisterRequest request = mapper.fromDto(dto);
        String token = authService.register(request);;
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.CREATED);
     }


    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto)
    {
        LoginRequest request = mapper.fromDto(dto);
        String token = authService.login(request);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);

    }
}
