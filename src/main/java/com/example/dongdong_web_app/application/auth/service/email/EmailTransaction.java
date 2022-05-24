package com.example.dongdong_web_app.application.auth.service.email;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import com.example.dongdong_web_app.application.auth.repository.AuthRepository;
import com.example.dongdong_web_app.application.auth.repository.EmailAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailTransaction {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private EmailAuthRepository emailAuthRepository;
    @Autowired
    private EmailService emailService;

    @Transactional
    public ResponseEntity registerEmail(final String email) {
        validEmail(email);

        EmailAuth emailAuth = emailAuthRepository.save(
                EmailAuth.builder()
                        .email(email)
                        .authToken(UUID.randomUUID().toString())
                        .expireDate(LocalDateTime.now().plusMinutes(5))
                        .expired(false)
                        .build());
        emailService.send(emailAuth.getEmail(), emailAuth.getAuthToken());

        return new ResponseEntity("success", null, HttpStatus.OK);
    }

    private void validEmail(final String email) {
        try{
            authRepository.findByUserEmail(email);
            throw new RuntimeException();
        }catch (Exception err){
            return ;
        }
    }
}