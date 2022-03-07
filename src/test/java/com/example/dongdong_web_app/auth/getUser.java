package com.example.dongdong_web_app.auth;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.entity.AuthEntity;
import com.example.dongdong_web_app.auth.repository.AuthRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class getUser {

    @Autowired
    AuthRepository authRepository;

    @Test
    public void 로그인테스트(){
        AuthEntity auth = authRepository.findByUserEmail("vpdls1511@gmail.com");
        Assertions.assertEquals(auth.getUserPassword(), "Test1234!!");
    }
}
