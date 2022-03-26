package com.example.dongdong_web_app.application.hospital.entitiy;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Data
@Entity(name = "hospital")
public class HospitalEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String hospitalName;
    private String hospitalAddress;
    private String hospitalTime;

    private long hospitalLat;
    private long hospitalLot;

    private String type;
}
