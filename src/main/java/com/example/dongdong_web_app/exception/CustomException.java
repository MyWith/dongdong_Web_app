package com.example.dongdong_web_app.exception;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException{

    @ExceptionHandler(value = JSONException.class)
    public ResponseEntity<String> jsonExceptionHandle(Exception e) {

        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
