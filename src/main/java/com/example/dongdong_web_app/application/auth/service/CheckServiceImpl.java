package com.example.dongdong_web_app.application.auth.service;

import com.example.dongdong_web_app.application.auth.repository.CheckRepository;
import com.example.dongdong_web_app.application.auth.service.interfaces.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Override
    public ResponseEntity checkNickName(final String target) {
        if (checkRepository.findByUserNickName(target) == null) {
            return new ResponseEntity("사용 가능한 닉네임 입니다.", null, HttpStatus.OK);
        }
        return new ResponseEntity("이미 존재하는 닉네임 입니다.", null, HttpStatus.OK);
    }
}
