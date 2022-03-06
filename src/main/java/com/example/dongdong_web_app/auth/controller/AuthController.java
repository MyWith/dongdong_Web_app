package com.example.dongdong_web_app.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/")
    public ResponseEntity signUp(){
        return new ResponseEntity("body",null,200);
    }
}
