package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthServiceImpl implements AuthService {

    @Override
    public SignInDto.Response getUserData(String user_email, String user_password) {

        return null;
    }
}
