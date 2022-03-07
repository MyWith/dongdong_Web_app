package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import org.springframework.stereotype.Service;

public interface AuthService {
    public SignInDto.Response getUserData(String user_email, String user_password);
}
