package com.example.dongdong_web_app.application.post.respository;

import com.example.dongdong_web_app.application.post.entity.PostEntity;

import com.example.dongdong_web_app.application.post.entity.QPostEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dongdong_web_app.application.post.entity.QPostEntity.postEntity;

@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {
    private final long NEW_POST_LIMIT_COUNT = 5L;

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<PostEntity> findFiveNewPosts() {
        return jpaQueryFactory
                .selectFrom(postEntity)
                .orderBy(postEntity.created_at.desc())
                .limit(NEW_POST_LIMIT_COUNT)
                .fetch();
    }
}
