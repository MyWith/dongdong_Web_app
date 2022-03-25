package com.example.dongdong_web_app.location.service;

import com.example.dongdong_web_app.auth.entity.AuthEntity;
import com.example.dongdong_web_app.location.dto.LocationDto;
import com.example.dongdong_web_app.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired private LocationRepository locationRepository;

    @Override
    public boolean saveUserLocation(LocationDto.Request locationDto){
        double lat = locationDto.getUserLat();
        double lot = locationDto.getUserLot();
        long userUid = locationDto.getUserUid();
        locationRepository.updateUserLocation(lat, lot , userUid);
        return false;
    }
}
