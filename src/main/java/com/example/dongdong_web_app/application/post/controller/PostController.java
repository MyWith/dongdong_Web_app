package com.example.dongdong_web_app.application.post.controller;

import com.example.dongdong_web_app.application.post.service.PostServiceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/post/")
public class PostController {

    @Autowired
    private PostServiceable postServiceable;

    @GetMapping("new-post")
    public ResponseEntity sendNewPost(@RequestParam int number){
        postServiceable.getNewFivePost(number);
        return null;
    }
}
