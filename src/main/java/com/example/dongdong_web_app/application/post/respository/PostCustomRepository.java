package com.example.dongdong_web_app.application.post.respository;

import com.querydsl.core.Tuple;

import java.util.List;

public interface PostCustomRepository {
    List<Tuple> findFiveNewPosts();
}
