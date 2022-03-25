package com.example.dongdong_web_app.application.auth.service;

import com.example.dongdong_web_app.application.auth.dto.SignInDto;
import com.example.dongdong_web_app.application.auth.dto.TokenDto;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService{

    @Autowired private JwtProvider jwtProvider;

    @Override
    public TokenDto reissueToken(TokenDto tokenDto) throws Exception {
        if(!jwtProvider.validationToken(tokenDto.getRefreshToken())) {
            throw new JSONException("Expired Token");
        }

        SignInDto.Response response = jwtProvider.getUserData(tokenDto.getAccessToken());

        tokenDto = jwtProvider.createToken(response.getInfo().getUserUid(), response.getInfo());

        return tokenDto;
    }

    @Override
    public TokenDto accessTokenCheck(TokenDto tokenDto) throws Exception {

        if(!jwtProvider.validationToken(tokenDto.getAccessToken())){
            return this.reissueToken(tokenDto);
        }

        return tokenDto;
    }
}
