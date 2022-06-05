package com.example.dongdong_web_app.application.hospital.controller;

import com.example.dongdong_web_app.application.hospital.dto.HospitalDto;
import com.example.dongdong_web_app.application.hospital.service.HospitalServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
@Slf4j
public class HospitalController {

    @Autowired
    HospitalServiceImpl hospitalService;

    @GetMapping("/all")
    public ResponseEntity getAnimalHospitals(@Param("lat") double lat, @Param("lot") double lot, @Param("distance") int distance){
        log.info("[GET] Hospital");
        log.info("nowUserLat - " + lat);
        log.info("nowUserLot - " + lot);
        return new ResponseEntity(hospitalService.getAllHospitalAndPharmacy(lot, lat, distance),null, HttpStatus.OK);
    }

}