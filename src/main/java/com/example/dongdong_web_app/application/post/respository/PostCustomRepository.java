package com.example.dongdong_web_app.application.post.respository;

import com.example.dongdong_web_app.application.post.entity.PostEntity;
import com.example.dongdong_web_app.application.post.entity.QPostEntity;

import java.util.List;

public interface PostCustomRepository {
    List<PostEntity> findFiveNewPosts();
}
