package com.example.dongdong_web_app.application.auth.service;

import com.example.dongdong_web_app.application.auth.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    private static final String CHECK_PASS_TEXT = "가능";
    private static final String CHECK_NO_PASS_TEXT = "불가능";

    @Autowired
    private CheckRepository checkRepository;

    public ResponseEntity checkNickName(final String target) {
        if (checkRepository.findByUserNickName(target) == null) {
            return new ResponseEntity(CHECK_PASS_TEXT, null, HttpStatus.OK);
        }
        return new ResponseEntity(CHECK_NO_PASS_TEXT, null, HttpStatus.OK);
    }
}
