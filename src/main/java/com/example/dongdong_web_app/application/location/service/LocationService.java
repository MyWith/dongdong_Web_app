package com.example.dongdong_web_app.application.location.service;

import com.example.dongdong_web_app.application.location.dto.LocationDto;

public interface LocationService {
    public boolean saveUserLocation(LocationDto.Request locationDto);
}
