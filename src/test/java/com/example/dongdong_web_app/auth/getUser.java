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
        String encodePassword = authRepository.findByUserEmail("vpdls1512@gmail.com").getUserPassword();
        String plainPassword = "Test1234!!";
        assertAll(
                () -> assertNotEquals(plainPassword, encodePassword),
                () -> assertTrue(passwordEncoder.matches(plainPassword, encodePassword))
        );
    }

    @Test
    public void 로그인_테스트_2() throws Exception {
        JSONObject request = new JSONObject();
        request.put("userEmail", "vpdls1512@gmail.com");
        request.put("userPassword", "Test1234!!");
        mockMvc.perform(
                        post("/api/auth/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request.toString()))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 로그인_테스트_3() throws Exception {
        JSONObject request = new JSONObject();
        request.put("accessToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Iiwicm9sZXMiOnsidXNlclVpZCI6NCwidXNlck5pY2tOYW1lIjoibkd5dSIsInVzZXJBZ2UiOjIzfSwiaWF0IjoxNjQ3NDA5ODQ0LCJleHAiOjE2NDc0MTM0NDR9.gv9cNrEkvJjzydgZhwGV-5ju36y045NiBxgYHOh55-U");
        mockMvc.perform(
                        post("/api/auth/check")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request.toString()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
