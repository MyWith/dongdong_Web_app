package com.example.dongdong_web_app.common.exception;

import com.example.dongdong_web_app.common.exception.exceptions.ExistEmailException;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = JSONException.class)
    public ResponseEntity<String> jsonExceptionHandle(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = ExistEmailException.class)
    public ResponseEntity<String> error(Exception err){
        return new ResponseEntity<String>(err.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
