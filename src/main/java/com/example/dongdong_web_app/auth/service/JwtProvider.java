package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.TokenDto;
import com.example.dongdong_web_app.auth.exception.ExpiredJwtTokenException;
import io.jsonwebtoken.Claims;

public interface JwtProvider {
    public TokenDto createToken(Long userid, SignInDto.Info response);
    public SignInDto.Response getUserData(String token) throws Exception;
    boolean validationToken(String token) throws ExpiredJwtTokenException;
    Claims parseClaims(String token);
}
