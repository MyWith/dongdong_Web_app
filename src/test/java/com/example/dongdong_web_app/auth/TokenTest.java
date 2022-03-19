package com.example.dongdong_web_app.auth;

import com.example.dongdong_web_app.auth.exception.ExpiredJwtTokenException;
import com.example.dongdong_web_app.auth.service.JwtProvider;
import com.example.dongdong_web_app.auth.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenTest {

    @Autowired
    private JwtProvider jwtProvider;


    String expiredToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0Iiwicm9sZXMiOnsidXNlclVpZCI6NCwidXNlck5pY2tOYW1lIjoibkd5dSIsInVzZXJBZ2UiOjIzfSwiaWF0IjoxNjQ3NDA5ODQ0LCJleHAiOjE2NDc0MTM0NDR9.gv9cNrEkvJjzydgZhwGV-5ju36y045NiBxgYHOh55-U";



    @Test
    public void 토큰테스트_1() throws ExpiredJwtTokenException {
        jwtProvider.validationToken(expiredToken);
    }
}
