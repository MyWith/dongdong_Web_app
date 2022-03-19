package com.example.dongdong_web_app.auth.exception;

import java.util.HashMap;
import java.util.Map;


public class ExceptionCreate {

    public Map<String, String> createMessage(String errCode , String message){
        Map<String, String> map = new HashMap<>();

        map.put("errCode", errCode);
        map.put("message", message);

        return map;
    }
}
