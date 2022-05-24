package com.example.dongdong_web_app.application.auth.service.email;

import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import com.example.dongdong_web_app.application.auth.repository.CheckCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@EnableAsync
@RequiredArgsConstructor
public class EmailService {
    private static final String EMAIL_CHECK_SUBJECT_COMMENT = "[마이윗] 이메일 인증";

    @Autowired
    private CheckCustomRepository checkCustomRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void send(final String email, final String authToken) {
        MimeMessage message = javaMailSender.createMimeMessage();
        String htmlMsg = "<a href=\"http://localhost:8080/api/auth/check/confirm-email?email=" + email + "&authToken=" + authToken + "\">인증하기</a>";

        try{
            message.setSubject(EMAIL_CHECK_SUBJECT_COMMENT);
            message.setText(htmlMsg, "UTF-8","html");
            message.setFrom(new InternetAddress("ngyu.test@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, email);

            javaMailSender.send(message);
            System.out.println(email + "SEND TO MAIL");
        }catch (Exception err){
            throw new RuntimeException(err);
        }
    }

    @Transactional
    public void confirmEmail(final String email, final String authToken) {
        EmailAuth emailAuth = checkCustomRepository.findValidAuthByEmail(email, authToken, LocalDateTime.now())
                .orElseThrow(() -> new AccessDeniedException("토큰이 존재하지 않습니다"));

        emailAuth.useToken();
    }
}
