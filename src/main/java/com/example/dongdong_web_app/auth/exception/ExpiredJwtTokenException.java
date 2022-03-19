package com.example.dongdong_web_app.auth.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExpiredJwtTokenException extends Throwable {

    static ExceptionCreate exceptionCreate;

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, String>> handleExpiredJwtException(Exception e){
        HttpHeaders responseHeader = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.NOT_MODIFIED;

        log.error("토큰 기한 만료 오류 발생");

        return new ResponseEntity<>(
                exceptionCreate.createMessage("8989","토큰 기한이 만료되었습니다."),
                responseHeader,
                responseStatus
        );
    }
}
