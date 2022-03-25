package com.example.dongdong_web_app.application.location.repository;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LocationRepository extends JpaRepository<AuthEntity, String> {

    @Modifying
    @Transactional
    @Query("UPDATE user u SET u.userLat=:userLat , u.userLon = :userLot WHERE u.userUid=:userUid")
    int updateUserLocation(double userLat, double userLot, long userUid);

}
