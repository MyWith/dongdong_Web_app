package com.example.dongdong_web_app.application.hospital.repository;

import com.example.dongdong_web_app.application.hospital.entitiy.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, String> {

}
