package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.SignUpDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface AuthService {
    public SignInDto.Response getUserData(String user_email, String user_password);
    public ResponseEntity saveUserData(SignUpDto.Request request);
}
