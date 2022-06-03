package com.example.dongdong_web_app.application.hospital.service;

import com.example.dongdong_web_app.application.hospital.dto.HospitalDto;
import com.example.dongdong_web_app.application.hospital.entitiy.HospitalEntity;
import com.example.dongdong_web_app.application.hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl{

    @Autowired
    HospitalRepository hospitalRepository;

    public List<HospitalEntity> getAllHospitalAndPharmacy(){
        return hospitalRepository.findAll();
    }
}
