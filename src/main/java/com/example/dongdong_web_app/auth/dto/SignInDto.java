package com.example.dongdong_web_app.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class SignInDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info{
        private int user_id;
        private String user_nick_name;
        private int user_age;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Animal{
        private String animal_name;
        private String animal_kind;
    }

    @Getter
    @Setter
    public static class Request{
        private String user_email;
        private String user_password;
    }

    @Getter
    @Setter
    public static class Response{
        private Info info;
        private Animal animal;
        private String user_email;
    }

}
