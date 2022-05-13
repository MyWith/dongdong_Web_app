package com.example.dongdong_web_app.application.auth.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthEntity is a Querydsl query type for AuthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthEntity extends EntityPathBase<AuthEntity> {

    private static final long serialVersionUID = 1247728300L;

    public static final QAuthEntity authEntity = new QAuthEntity("authEntity");

    public final com.example.dongdong_web_app.common.QBaseTimeEntity _super = new com.example.dongdong_web_app.common.QBaseTimeEntity(this);

    public final DateTimePath<java.util.Date> animalAge = createDateTime("animalAge", java.util.Date.class);

    public final StringPath animalKind = createString("animalKind");

    public final StringPath animalName = createString("animalName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created_at = _super.created_at;

    public final StringPath streetEUPMYENDONG = createString("streetEUPMYENDONG");

    public final StringPath streetSIDO = createString("streetSIDO");

    public final StringPath streetSIGUNGU = createString("streetSIGUNGU");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated_at = _super.updated_at;

    public final DateTimePath<java.util.Date> userAge = createDateTime("userAge", java.util.Date.class);

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userNickName = createString("userNickName");

    public final StringPath userPassword = createString("userPassword");

    public final NumberPath<Long> userUid = createNumber("userUid", Long.class);

    public QAuthEntity(String variable) {
        super(AuthEntity.class, forVariable(variable));
    }

    public QAuthEntity(Path<? extends AuthEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthEntity(PathMetadata metadata) {
        super(AuthEntity.class, metadata);
    }

}

