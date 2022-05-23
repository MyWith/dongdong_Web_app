package com.example.dongdong_web_app.application.post.respository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dongdong_web_app.application.auth.entity.QAuthEntity.authEntity;
import static com.example.dongdong_web_app.application.post.entity.QPostEntity.postEntity;

@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {
    private final long NEW_POST_LIMIT_COUNT = 5L;

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Tuple> findFiveNewPosts() {
        return jpaQueryFactory
                .select(
                        postEntity,
                        authEntity
                )
                .from(postEntity)
                .leftJoin(authEntity).on(postEntity.userUid.eq(authEntity.userUid))
                .orderBy(postEntity.created_at.desc())
                .limit(NEW_POST_LIMIT_COUNT)
                .fetch();
    }
}
