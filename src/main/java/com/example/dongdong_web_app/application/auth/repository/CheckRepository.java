package com.example.dongdong_web_app.application.auth.repository;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CheckRepository extends JpaRepository<AuthEntity, Boolean>{
    AuthEntity findByUserNickName(String nickname);
}
