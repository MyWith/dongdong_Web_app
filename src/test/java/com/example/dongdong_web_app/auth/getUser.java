package com.example.dongdong_web_app.auth;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.entity.AuthEntity;
import com.example.dongdong_web_app.auth.repository.AuthRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class getUser {

    @Autowired
    AuthRepository authRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void 로그인_테스트_1(){
        String encodePassword = authRepository.findByUserEmail("vpdls1511@gmail.com").getUserPassword();
        String plainPassword = "Test1234!!";
        assertAll(
                () -> assertNotEquals(plainPassword, encodePassword),
                () -> assertTrue(passwordEncoder.matches(plainPassword, encodePassword))
        );
    }

    @Test
    public void 로그인_테스트_2() throws Exception {
        JSONObject request = new JSONObject();
        request.put("userEmail", "vpdls1511@gmail.com");
        request.put("userPassword", "Test1234!!");
        mockMvc.perform(
                        post("/api/auth/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request.toString()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
