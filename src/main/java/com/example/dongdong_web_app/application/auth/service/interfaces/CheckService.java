package com.example.dongdong_web_app.application.auth.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface CheckService {

    public ResponseEntity checkNickName(final String nickname);
}
