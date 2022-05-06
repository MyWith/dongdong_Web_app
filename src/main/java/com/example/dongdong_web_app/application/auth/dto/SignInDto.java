package com.example.dongdong_web_app.application.auth.dto;

import lombok.*;

import java.util.Date;

public class SignInDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info{
        private long userUid;
        private String userNickName;
        private Date userAge;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Animal{
        private String animalName;
        private String animalKind;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location{
        private String streetSIDO;
        private String streetSIGUNGU;
        private String streetEUPMYENDONG;
    }

    @Getter
    @Setter
    public static class Request{
        private String userEmail;
        private String userPassword;
    }

    @Getter
    @Setter
    @Builder
    public static class Response{
        private Info info;
        private Animal animal;
        private Location location;
        private TokenDto token;
        private String userEmail;
    }

}
