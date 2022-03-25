package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.TokenDto;
import io.jsonwebtoken.Claims;

public interface JwtProvider {
    public TokenDto createToken(Long userid, SignInDto.Info response);
    public SignInDto.Response getUserData(String token) throws Exception;
    boolean validationToken(String token);
    Claims parseClaims(String token);
}
