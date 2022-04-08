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
        double lat = (double) locationDto.getUserLat();
        double lon = (double) locationDto.getUserLon();
        long userUid = (long) locationDto.getUserUid();

        log.info("LAT : " + String.valueOf(lat));
        log.info("LON : " + String.valueOf(lon));
        log.info("userUid : " + String.valueOf(userUid));

        Optional<AuthEntity> user = locationRepository.findById(String.valueOf(userUid));

        user.ifPresent( selectUser ->{
            selectUser.setUserLat(lat);
            selectUser.setUserLon(lon);
            locationRepository.save(selectUser);
        } );

        return false;
    }

    @Override
    public List<AuthEntity> getNearUser(LocationDto.Request nowUserLocation){


        return null;
    }
}
