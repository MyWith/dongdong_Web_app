package com.example.dongdong_web_app.application.auth.service.email;

import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import com.example.dongdong_web_app.application.auth.repository.AuthRepository;
import com.example.dongdong_web_app.application.auth.repository.EmailAuthRepository;
import com.example.dongdong_web_app.common.exception.exceptions.ExistEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
                        .authToken(UUID.randomUUID().toString().substring(0,5))
                        .expireDate(LocalDateTime.now().plusMinutes(5))
                        .expired(false)
                        .build());
        emailService.send(emailAuth.getEmail(), emailAuth.getAuthToken());

        return new ResponseEntity("success", null, HttpStatus.OK);
    }

    private void validEmail(final String email) {
        if (authRepository.existsByUserEmail(email)) {
            throw new ExistEmailException();
        }
    }
}
