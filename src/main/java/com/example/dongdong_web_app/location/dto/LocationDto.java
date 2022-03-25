package com.example.dongdong_web_app.location.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LocationDto {

    @Getter
    @Setter
    @Builder
    public static class Request{
        private long userUid;
        private double userLat;
        private double userLot;
    }
}
