package com.example.dongdong_web_app.auth.service;


import com.example.dongdong_web_app.auth.dto.TokenDto;

public interface JwtService {
    public TokenDto reissueToken(TokenDto tokenDto) throws Exception;
    public TokenDto accessTokenCheck(TokenDto tokenDto) throws Exception;
}
