package com.example.dongdong_web_app.application.hospital.dto;

import lombok.*;

public class HospitalDto {

    @Getter
    @Setter
    @Builder
    public static class Location{
        private long userLat;
        private long userLot;
    }

    public static class Hospital{
        private Location location;
        private String hospitalName;
        private String hospitalAddress;
        private String hospitalTime;
    }

}
