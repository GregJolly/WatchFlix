package com.watchflix.app.service;

import com.watchflix.app.domain.LoginRequest;
import com.watchflix.app.domain.RegisterRequest;
import com.watchflix.app.domain.entity.User;

public interface AuthService {
    String login(LoginRequest request);
    String register(RegisterRequest request);
}
