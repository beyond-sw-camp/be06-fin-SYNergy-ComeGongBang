package com.synergy.backend.domain.atelier.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAtelierProfileImages is a Querydsl query type for AtelierProfileImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAtelierProfileImages extends EntityPathBase<AtelierProfileImages> {

    private static final long serialVersionUID = 637593245L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAtelierProfileImages atelierProfileImages = new QAtelierProfileImages("atelierProfileImages");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final QAtelier atelier;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public QAtelierProfileImages(String variable) {
        this(AtelierProfileImages.class, forVariable(variable), INITS);
    }

    public QAtelierProfileImages(Path<? extends AtelierProfileImages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAtelierProfileImages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAtelierProfileImages(PathMetadata metadata, PathInits inits) {
        this(AtelierProfileImages.class, metadata, inits);
    }

    public QAtelierProfileImages(Class<? extends AtelierProfileImages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.atelier = inits.isInitialized("atelier") ? new QAtelier(forProperty("atelier")) : null;
    }

}

