package com.example.dongdong_web_app.application.auth.controller;

import com.example.dongdong_web_app.application.auth.service.interfaces.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    @GetMapping("nickname")
    public ResponseEntity checkUserNickname(@RequestParam String nickname){
        return checkService.checkNickName(nickname);
    }
}
