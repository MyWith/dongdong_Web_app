package com.example.dongdong_web_app.application.auth.service.email;

import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import com.example.dongdong_web_app.application.auth.repository.CheckCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Properties;

@Service
@EnableAsync
@RequiredArgsConstructor
public class EmailService {
    private static final String EMAIL_CHECK_SUBJECT_COMMENT = "[마이윗] 이메일 인증";
    private static final String FROM_NAME = "마이윗";
    private static final int PORT = 587;

    @Value("${config.host}")
    private String URL;
    @Value("${spring.mail.host}")
    private String HOST;
    @Value("${spring.mail.username}")
    private String FROM;
    @Value("${spring.mail.username}")
    private String SMTP_USERNAME;
    @Value("${spring.mail.password}")
    private String SMTP_PASSWORD;


    @Autowired
    private CheckCustomRepository checkCustomRepository;

    @Async
    public void send(final String email, final String authToken) {
        Properties props = System.getProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

        String htmlMsg = "인증번호 : " + authToken;

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(FROM, FROM_NAME));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(EMAIL_CHECK_SUBJECT_COMMENT);
            message.setContent(htmlMsg, "text/html;charset=euc-kr");

            System.out.println("Sending...");

            Transport transport = session.getTransport();
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println("Email sent!");
        } catch (Exception err) {
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
