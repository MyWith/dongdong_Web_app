package com.example.dongdong_web_app.location.service;

import com.example.dongdong_web_app.location.dto.LocationDto;

public interface LocationService {
    public boolean saveUserLocation(LocationDto.Request locationDto);
}
