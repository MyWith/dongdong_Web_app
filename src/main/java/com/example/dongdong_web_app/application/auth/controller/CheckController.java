package com.example.dongdong_web_app.application.auth.controller;

import com.example.dongdong_web_app.application.auth.repository.AuthRepository;
import com.example.dongdong_web_app.application.auth.service.AuthService;
import com.example.dongdong_web_app.application.auth.service.CheckService;
import com.example.dongdong_web_app.application.auth.service.email.EmailService;
import com.example.dongdong_web_app.application.auth.service.email.EmailTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailTransaction emailTransaction;

    @GetMapping("nickname")
    public ResponseEntity checkUserNickname(@RequestParam String nickname){
        return checkService.checkNickName(nickname);
    }

    @GetMapping("email-check")
    public ResponseEntity checkUserEmail(@RequestParam String email){
        return emailTransaction.registerEmail(email);
    }

    @GetMapping("confirm-email")
    public String confirmEmail(@RequestParam String email, @RequestParam String authToken){
        emailService.confirmEmail(email, authToken);
        return "success";
    }
}
