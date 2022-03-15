package com.example.dongdong_web_app.auth.controller;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.dto.SignUpDto;
import com.example.dongdong_web_app.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public ResponseEntity signIn(@RequestBody SignInDto.Request signin) {
        SignInDto.Response response = authService.getUserData(signin.getUserEmail(), signin.getUserPassword());
        return new ResponseEntity(response, null, 200);
    }

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpDto.Request signup){
        return authService.saveUserData(signup);
    }
}
