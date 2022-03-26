package com.example.dongdong_web_app.application.hospital.service;

import com.example.dongdong_web_app.application.hospital.dto.HospitalDto;
import com.example.dongdong_web_app.application.hospital.entitiy.HospitalEntity;
import com.example.dongdong_web_app.application.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HospitalServiceImpl implements HospitalService{

    @Autowired
    HospitalRepository hospitalRepository;

    public List<HospitalEntity> getAllHospitalAndPharmacy(){
        return hospitalRepository.findAll();
    }
}
