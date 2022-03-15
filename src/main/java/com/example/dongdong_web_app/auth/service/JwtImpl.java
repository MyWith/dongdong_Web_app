package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtImpl implements Jwt {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.role}")
    private String Role;

    private final Long accessTokenExpTime = 60*60*1000L; // 1Hour
    private final Long refreshTokenExpTime = 60*60*1000L; // 1Hour

    @Override
    public SignInDto.Token createToken(Long userid, SignInDto.Info response) {

        Claims claims = Jwts.claims().setSubject(String.valueOf(userid));
        claims.put(Role, response);

        Date now = new Date();

        String accessToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + accessTokenExpTime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        String refreshToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setExpiration(new Date(now.getTime() + refreshTokenExpTime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return new SignInDto.Token(accessToken, refreshToken);
    }

}
