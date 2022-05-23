package com.example.dongdong_web_app.application.post.service;

import com.example.dongdong_web_app.application.auth.entity.AuthEntity;
import com.example.dongdong_web_app.application.post.entity.PostEntity;
import com.example.dongdong_web_app.application.post.respository.PostRepository;
import com.querydsl.core.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity getNewFivePost() {

        List lst = postRepository.findFiveNewPosts().stream()
                .map(item -> Stream.of(
                        item.get(0, PostEntity.class),
                        item.get(1, AuthEntity.class))
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toList());

        return new ResponseEntity(lst, null, HttpStatus.OK);
    }
}
