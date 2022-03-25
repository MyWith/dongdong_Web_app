package com.example.dongdong_web_app.location;

import com.example.dongdong_web_app.application.location.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;



@SpringBootTest
@AutoConfigureMockMvc
public class updateLocation {
    @Autowired LocationRepository locationRepository;
    @Autowired MockMvc mockMvc;
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

    @Test
    public void 위치정보업데이트_2() throws Exception {

        mockMvc.perform(patch("/api/location/set")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .param("userLat", "0.1234")
                .param("userLot", "1.214124")
                .param("userUid", "1")
        ).andDo(print());
    }

    @Test
    public void 위치정보업데이트_3() throws Exception {

        mockMvc.perform(patch("/api/location/set")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .param("userLat", "0.1234")
                .param("userLot", "1.214124")
        ).andDo(print());
    }
}
