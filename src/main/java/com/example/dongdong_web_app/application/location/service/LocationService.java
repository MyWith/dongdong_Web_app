package com.example.dongdong_web_app.application.location.service;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.location.dto.LocationDto;

import java.util.List;

public interface LocationService {
    public boolean saveUserLocation(LocationDto.Request locationDto);
    public List<AuthEntity> getNearUser(LocationDto.Request nowUserLocation);
}
