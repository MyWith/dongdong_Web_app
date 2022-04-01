package com.example.dongdong_web_app.application.auth.service;

import com.example.dongdong_web_app.application.auth.dto.SignInDto;
import com.example.dongdong_web_app.application.auth.dto.TokenDto;
import io.jsonwebtoken.Claims;

public interface JwtProvider {
    public TokenDto createToken(Long userid, SignInDto.Info response);
    public SignInDto.Response getUserData(TokenDto token) throws Exception;
    boolean validationToken(String token);
    Claims parseClaims(String token);

}
