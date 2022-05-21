package com.example.dongdong_web_app.application.post.service;

import com.example.dongdong_web_app.application.post.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public ResponseEntity getNewFivePost() {
        return new ResponseEntity(postRepository.findFiveNewPosts(), null , HttpStatus.OK);
    }
}
