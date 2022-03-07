package com.example.dongdong_web_app.auth.dto;

import lombok.*;

public class SignUpDto {
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
    public static class Animal{
        private String animalName;
        private String animalKind;
    }

    @Getter
    @Setter
    public static class Request{
        private SignUpDto.Info info;
        private SignUpDto.Animal animal;
        private String userEmail;
        private String userPassword;
    }
}
