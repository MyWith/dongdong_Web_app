package com.example.dongdong_web_app.application.auth.repository;

import com.example.dongdong_web_app.application.auth.entity.EmailAuth;
import com.example.dongdong_web_app.application.auth.entity.QEmailAuth;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.dongdong_web_app.application.auth.entity.QEmailAuth.emailAuth;

@Repository
public class CheckEmailRepository implements CheckCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public CheckEmailRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<EmailAuth> findValidAuthByEmail(String email, String authToken, LocalDateTime currentTime) {
        EmailAuth emailCheck = jpaQueryFactory
                .selectFrom(emailAuth)
                .where(QEmailAuth.emailAuth.email.eq(email),
                        QEmailAuth.emailAuth.authToken.eq(authToken),
                        QEmailAuth.emailAuth.expireDate.goe(currentTime),
                        QEmailAuth.emailAuth.expired.eq(false))
                .fetchFirst();

        return Optional.ofNullable(emailCheck);
    }
}
