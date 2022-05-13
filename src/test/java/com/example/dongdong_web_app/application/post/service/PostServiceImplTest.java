package com.example.dongdong_web_app.application.post.service;

import com.example.dongdong_web_app.application.post.entity.PostEntity;
import com.example.dongdong_web_app.application.post.entity.QPostEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void QUERY_DSL_테스트(){
        JPAQuery<PostEntity> query = new JPAQuery<PostEntity>(entityManager);
        QPostEntity postEntity = new QPostEntity("postEntity");

        List<PostEntity> posts = query.from(postEntity)
                .orderBy(postEntity.postId.asc())
                .fetch();

        assertThat(posts.get(0).getPostId()).isEqualTo(1);
    }
}