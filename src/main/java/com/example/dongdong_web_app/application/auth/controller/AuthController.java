package com.example.dongdong_web_app.application.auth.controller;

import com.example.dongdong_web_app.application.auth.dto.SignInDto;
import com.example.dongdong_web_app.application.auth.dto.SignUpDto;
import com.example.dongdong_web_app.application.auth.dto.TokenDto;
import com.example.dongdong_web_app.application.auth.service.interfaces.AuthService;
import com.example.dongdong_web_app.application.auth.service.interfaces.JwtProvider;
import com.example.dongdong_web_app.application.auth.service.interfaces.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
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

    @PostMapping("/autologin")
    public ResponseEntity autoSignIn(@RequestBody TokenDto tokenDto) throws Exception {
        SignInDto.Response response = jwtProvider.getUserData(tokenDto);
        return new ResponseEntity(response, null, 200);
    }


    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpDto.Request signup){
        log.info("[POST] SignUpData - " + signup);
        return authService.saveUserData(signup);
    }
}
