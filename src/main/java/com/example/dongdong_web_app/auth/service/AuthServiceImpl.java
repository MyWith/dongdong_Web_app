package com.example.dongdong_web_app.auth.service;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.SignUpDto;
import com.example.dongdong_web_app.auth.entity.AuthEntity;
import com.example.dongdong_web_app.auth.repository.AuthRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private static final String SECRET_KEY = "1io2jipowejfisjkofj0198q3ju4i1jkl3j4pr13jifsadlkjfapsc89vqu34";

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SignInDto.Response getUserData(String user_email, String user_password) {
        String getPassword = authRepository.findByUserEmail(user_email).getUserPassword();

        String token = this.createToken(user_email, (2*1000*60));
        Map<String, Object> map = new LinkedHashMap<>() ;
        map.put("result", token);

        if(passwordEncoder.matches(user_password, getPassword)){
            AuthEntity UserData = authRepository.findByUserEmail(user_email);
            SignInDto.Info info = new SignInDto.Info(UserData.getUserUid(), UserData.getUserNickName(), UserData.getUserAge());
            SignInDto.Animal animal = new SignInDto.Animal(UserData.getAnimalName(), UserData.getAnimalKind());

            SignInDto.Response response = SignInDto.Response.builder()
                    .userEmail(UserData.getUserEmail())
                    .info(info)
                    .animal(animal)
                    .build();

            return response;
        }else{
            return null;
        }
    }

    @Override
    public ResponseEntity saveUserData(SignUpDto.Request request) {
        String planText = request.getUserPassword();
        String encodePassword = passwordEncoder.encode(planText);
        AuthEntity auth;
        try{
            auth = AuthEntity.builder()
                    .userEmail(request.getUserEmail())
                    .userPassword(encodePassword)
                    .userNickName(request.getInfo().getUserNickName())
                    .userAge(request.getInfo().getUserAge())
                    .animalKind(request.getAnimal().getAnimalKind())
                    .animalName(request.getAnimal().getAnimalName())
                    .build();

            authRepository.save(auth);

            return new ResponseEntity(null,null,200);
        }catch (Exception e){
            return new ResponseEntity(null,null,400);
        }
    }

    @Override
    public String createToken(String subject, long expTime){
        if(expTime <= 0) throw new RuntimeException("exp time is not over 0");

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject)
                .signWith(signingKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact();
    }


    //valid Token Method
    @Override
    public boolean getSubject(String token, String user_email){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return (claims.getSubject() == user_email);
    }
}