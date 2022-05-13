package com.example.dongdong_web_app.application.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostEntity is a Querydsl query type for PostEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostEntity extends EntityPathBase<PostEntity> {

    private static final long serialVersionUID = -2036965220L;

    public static final QPostEntity postEntity = new QPostEntity("postEntity");

    public final com.example.dongdong_web_app.common.QBaseTimeEntity _super = new com.example.dongdong_web_app.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created_at = _super.created_at;

    public final NumberPath<Integer> postComment = createNumber("postComment", Integer.class);

    public final StringPath postDesc = createString("postDesc");

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final StringPath postImage = createString("postImage");

    public final NumberPath<Integer> postLike = createNumber("postLike", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated_at = _super.updated_at;

    public final NumberPath<Long> userUid = createNumber("userUid", Long.class);

    public QPostEntity(String variable) {
        super(PostEntity.class, forVariable(variable));
    }

    public QPostEntity(Path<? extends PostEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostEntity(PathMetadata metadata) {
        super(PostEntity.class, metadata);
    }

}

