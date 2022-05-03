package com.example.dongdong_web_app.application.post.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    private long userUid;
    private String postDesc;
    private Date postCreateDate;
    private Date postUpdateDate;

    private int postComment;
    private int postLike;

}
