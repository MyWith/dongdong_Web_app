package com.example.dongdong_web_app.application.post.service;

import com.example.dongdong_web_app.application.post.entity.PostEntity;
import com.example.dongdong_web_app.application.post.entity.QPostEntity;
import com.example.dongdong_web_app.application.post.respository.PostRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PostServiceImpl implements PostServiceable{

    @Autowired
    private PostRepository postRepository;

    @Override
    public ResponseEntity getNewFivePost(int number) {
        return new ResponseEntity(postRepository.findFiveNewPosts(), null , HttpStatus.OK);
    }
}
