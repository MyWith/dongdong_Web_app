package com.example.dongdong_web_app.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class TokenTest {

    @Autowired MockMvc mockMvc;

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Iiwicm9sZXMiOnsidXNlclVpZCI6NCwidXNlck5pY2tOYW1lIjoibkd5dSIsInVzZXJBZ2UiOjIzfSwiaWF0IjoxNjQ3NDA5ODQ0LCJleHAiOjE2NDc0MTM0NDR9.gv9cNrEkvJjzydgZhwGV-5ju36y045NiBxgYHOh55-U";

    @Test
    public void 토큰테스트_1() throws Exception {
        mockMvc.perform(get("/api/auth/exceptionTest").param("token",token))
                .andDo(print());
    }
}
