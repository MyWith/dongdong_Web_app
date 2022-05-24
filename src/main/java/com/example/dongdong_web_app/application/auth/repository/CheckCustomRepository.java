package com.example.dongdong_web_app.application.auth.repository;

import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CheckCustomRepository {
    Optional<EmailAuth> findValidAuthByEmail(final String email, final String authToken, final LocalDateTime currentTime);
}
