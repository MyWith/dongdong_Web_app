package com.example.dongdong_web_app.auth.controller;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.SignUpDto;
import com.example.dongdong_web_app.auth.dto.TokenDto;
import com.example.dongdong_web_app.auth.service.AuthService;
import com.example.dongdong_web_app.auth.service.JwtProvider;
import com.example.dongdong_web_app.auth.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired private AuthService authService;
    @Autowired private JwtProvider jwtProvider;
    @Autowired private JwtService jwtService;

    @PostMapping("/")
    public ResponseEntity signIn(@RequestBody SignInDto.Request signin) {
        log.info("[POST] SignInData - " + signin.getUserEmail());
        log.info("[POST] SignInData - " + signin.getUserPassword());
        SignInDto.Response response = authService.getUserData(signin.getUserEmail(), signin.getUserPassword());
        return new ResponseEntity(response, null, 200);
    }

    @PostMapping("/signintest")
    public ResponseEntity signInTest(@ModelAttribute SignInDto.Request signin){
        SignInDto.Response response = authService.getUserData(signin.getUserEmail(), signin.getUserPassword());
        return new ResponseEntity(response, null, 200);
    }

    @PostMapping("/tokencheck")
    public ResponseEntity checkToken(@RequestBody TokenDto token) throws Exception {
        log.info("[POST] TokenData - " + token.getAccessToken());
        log.info("[POST] TokenData - " + token.getRefreshToken());
        TokenDto validToken = jwtService.accessTokenCheck(token);
        return new ResponseEntity(validToken, null, 200);
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpDto.Request signup){
        log.info("[POST] SignUpData - " + signup);
        return authService.saveUserData(signup);
    }

    @GetMapping("/exceptionTest")
    public String exception(@Param("token") String token) throws JSONException {
        jwtProvider.validationToken(token);
        return "TEST";
    }
}
