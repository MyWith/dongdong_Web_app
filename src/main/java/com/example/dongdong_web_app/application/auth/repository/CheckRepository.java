package com.example.dongdong_web_app.application.auth.repository;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<AuthEntity, Boolean> {
    AuthEntity findByUserNickName(String nickname);
}
