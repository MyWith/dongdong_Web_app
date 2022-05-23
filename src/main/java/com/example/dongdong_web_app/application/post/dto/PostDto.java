package com.example.dongdong_web_app.application.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class PostDto {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class PostInfo{
        private long postId;

        private long userUid;
        private String postDesc;
        private String postImage;

        private int postComment;
        private int postLike;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class AuthInfo{
        private long userUid;
        private String userEmail;
        private String userPassword;
        private String userNickName;
        private Date userAge;

        private String animalName;
        private String animalKind;
        private Date animalAge;

        private String streetSIDO;
        private String streetSIGUNGU;
        private String streetEUPMYENDONG;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class Request{
        private PostInfo postInfo;
        private AuthInfo authInfo;
    }
}
