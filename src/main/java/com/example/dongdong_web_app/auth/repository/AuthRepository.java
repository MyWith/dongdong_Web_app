package com.example.dongdong_web_app.auth.repository;

import com.example.dongdong_web_app.auth.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, String> {

}
