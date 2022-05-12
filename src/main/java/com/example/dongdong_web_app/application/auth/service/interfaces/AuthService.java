package com.example.dongdong_web_app.application.auth.service.interfaces;

import com.example.dongdong_web_app.application.auth.dto.SignInDto;
import com.example.dongdong_web_app.application.auth.dto.SignUpDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface AuthService {
    public SignInDto.Response getUserData(String user_email, String user_password);

    public ResponseEntity saveUserData(SignUpDto.Request request);

}
