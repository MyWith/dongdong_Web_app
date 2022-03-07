package com.example.dongdong_web_app.auth.controller;

import com.example.dongdong_web_app.auth.dto.SignInDto;
import com.example.dongdong_web_app.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/")
    public ResponseEntity signIn(@RequestBody SignInDto.Request signin) {
        //authService.getUserData(signin.getUser_email(), signin.getUser_password());
        return new ResponseEntity("body",null,200);
    }
}
