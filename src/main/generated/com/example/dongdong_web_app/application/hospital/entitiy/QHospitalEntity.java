package com.example.dongdong_web_app.application.hospital.entitiy;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHospitalEntity is a Querydsl query type for HospitalEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHospitalEntity extends EntityPathBase<HospitalEntity> {

    private static final long serialVersionUID = 48305597L;

    public static final QHospitalEntity hospitalEntity = new QHospitalEntity("hospitalEntity");

    public final StringPath hospitalAddress = createString("hospitalAddress");

    public final NumberPath<Long> hospitalLat = createNumber("hospitalLat", Long.class);

    public final NumberPath<Long> hospitalLot = createNumber("hospitalLot", Long.class);

    public final StringPath hospitalName = createString("hospitalName");

    public final StringPath hospitalTime = createString("hospitalTime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath type = createString("type");

    public QHospitalEntity(String variable) {
        super(HospitalEntity.class, forVariable(variable));
    }

    public QHospitalEntity(Path<? extends HospitalEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHospitalEntity(PathMetadata metadata) {
        super(HospitalEntity.class, metadata);
    }

}

