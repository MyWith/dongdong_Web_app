package com.example.dongdong_web_app.application.location.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

public class LocationDto {

    @Getter
    @Setter
    @Builder
    public static class Request{
        private long userUid;
        private double userLat;
        private double userLon;
    }
}
