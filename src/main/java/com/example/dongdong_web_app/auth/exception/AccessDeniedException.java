package com.example.dongdong_web_app.auth.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class AccessDeniedException extends Throwable {

    static ExceptionCreate exceptionCreate;

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String,String>> handleAccessDeniedException(Exception e){
        HttpHeaders responseHeader = new HttpHeaders();
        HttpStatus responseStatus = HttpStatus.BAD_REQUEST;


        return new ResponseEntity<>(
                exceptionCreate.createMessage("9999","권한이 없습니다."),
                responseHeader,
                responseStatus
        );
    }
}
