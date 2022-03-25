package com.example.dongdong_web_app.location;


import com.example.dongdong_web_app.location.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class updateLocation {
    @Autowired LocationRepository locationRepository;


    @Test
    public void 위치정보업데이트_1(){
        double lat = 0.123;
        double lot = 1.123;
        long uid = 1;

        try {
            locationRepository.updateUserLocation(lat,lot,uid);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
