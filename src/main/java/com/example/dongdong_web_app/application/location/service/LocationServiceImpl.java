package com.example.dongdong_web_app.application.location.service;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.location.dto.LocationDto;
import com.example.dongdong_web_app.application.location.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService{

    @Autowired private LocationRepository locationRepository;

    @Override
    public boolean saveUserLocation(LocationDto.Request locationDto){
        String sido = "";
        String sigungu = "";
        String eupmyendong = "";
        long userUid = (long) locationDto.getUserUid();

        log.info("LAT : " + sido);
        log.info("LON : " + sigungu);
        log.info("LON : " + eupmyendong);
        log.info("userUid : " + String.valueOf(userUid));

        Optional<AuthEntity> user = locationRepository.findById(String.valueOf(userUid));

        user.ifPresent( selectUser ->{
            selectUser.setStreetSIDO(sido);
            selectUser.setStreetSIGUNGU(sigungu);
            selectUser.setStreetEUPMYENDONG(eupmyendong);
            locationRepository.save(selectUser);
        } );

        return false;
    }

    @Override
    public List<AuthEntity> getNearUser(LocationDto.Request nowUserLocation){


        return null;
    }
}
