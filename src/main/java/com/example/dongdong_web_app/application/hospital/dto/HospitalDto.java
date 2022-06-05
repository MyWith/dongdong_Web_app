package com.example.dongdong_web_app.application.hospital.dto;

import lombok.*;

public class HospitalDto {

    @Data
    public class Request{
        double lat;
        double lot;
        int distance;
    }
}
