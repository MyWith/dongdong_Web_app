package com.example.dongdong_web_app.application.hospital.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void getNearHospital(){
        double lot = 127.1489532;
        double lat = 35.8170112;
        int distance = 2000;
    }
}