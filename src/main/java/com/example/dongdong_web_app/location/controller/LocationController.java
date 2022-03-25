package com.example.dongdong_web_app.location.controller;

import com.example.dongdong_web_app.location.dto.LocationDto;
import com.example.dongdong_web_app.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired private LocationService locationService;

    @PatchMapping("/set")
    public ResponseEntity setUserLocation(@ModelAttribute LocationDto locationDto){

        return new ResponseEntity("Save Successful", null , HttpStatus.OK);
    }
}
