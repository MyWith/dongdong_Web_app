package com.example.dongdong_web_app.auth.dto;

import lombok.*;

public class SignInDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info{
        private long userUid;
        private String userNickName;
        private int userAge;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Token{
        private String accessToken;
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
        private Token token;
        private String userEmail;
    }

}
