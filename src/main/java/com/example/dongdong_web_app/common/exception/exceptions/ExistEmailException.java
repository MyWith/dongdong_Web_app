package com.example.dongdong_web_app.common.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExistEmailException extends RuntimeException {

    private static final String exceptionMessage = "이미 존재하는 이메일 입니다.";

    public ExistEmailException() {
        super(exceptionMessage);
    }
}
