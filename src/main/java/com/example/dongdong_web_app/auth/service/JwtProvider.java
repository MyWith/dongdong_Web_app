package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;

public interface JwtProvider {
    public SignInDto.Token createToken(Long userid, SignInDto.Info response);
}
