package com.example.dongdong_web_app.application.hospital.dto;

import lombok.*;

public class HospitalDto {

    @Getter
    @Setter
    @Builder
    public static class Location {
        private double userLat;
        private double userLot;
    }

    public static class Hospital {
        private Location location;
        private String type;
        private String hospitalName;
        private String hospitalAddress;
        private String hospitalTime;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private double hospitalLat;
        private double hospitalLot;
        private String hospitalName;
    }

}
