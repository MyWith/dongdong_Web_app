package com.example.dongdong_web_app.auth;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.auth.repository.AuthRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UpdateLocation {

    @Autowired
    AuthRepository authRepository;

    @Test
    public void 유저위치정보업데이트(){
        Optional<AuthEntity> user = authRepository.findById("1");
        user.ifPresent(selectUser -> {
            selectUser.setUserLat(14.12124123);
            selectUser.setUserLon(14.12224421);
            authRepository.save(selectUser);
        });
    }
}
