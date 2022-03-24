package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.TokenDto;
import com.example.dongdong_web_app.auth.entity.AuthEntity;
import com.example.dongdong_web_app.auth.repository.AuthRepository;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtProviderImpl implements JwtProvider {

    @Autowired AuthRepository authRepository;

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.role}")
    private String Role;

    private final Long accessTokenExpTime = 60*60*1000L; // 1Hour
    private final Long refreshTokenExpTime = 60*60*1000L; // 1Hour

    @Override
    public TokenDto createToken(Long userid, SignInDto.Info response) {

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

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public SignInDto.Response getUserData(String token) throws Exception {
        Claims claims = parseClaims(token);

        if (claims.get(Role) == null){
            throw new Exception("Role is not defined");
        }

        AuthEntity auth = authRepository.findByUserUid(Long.valueOf(claims.getSubject()));
        SignInDto.Info info = new SignInDto.Info(auth.getUserUid(), auth.getUserNickName(), auth.getUserAge());
        SignInDto.Animal animal = new SignInDto.Animal(auth.getAnimalName(), auth.getAnimalKind());

        return SignInDto.Response.builder()
                .info(info)
                .animal(animal)
                .userEmail(auth.getUserEmail())
                .build();
    }

    @Override
    public boolean validationToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    @Override
    public Claims parseClaims(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            return e.getClaims();
        }
    }
}