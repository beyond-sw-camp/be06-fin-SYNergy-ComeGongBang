package com.synergy.backend.domain.atelier.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAtelier is a Querydsl query type for Atelier
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAtelier extends EntityPathBase<Atelier> {

    private static final long serialVersionUID = 583880004L;

    public static final QAtelier atelier = new QAtelier("atelier");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    public final NumberPath<Double> averageScore = createNumber("averageScore", Double.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> havingFollowerCount = createNumber("havingFollowerCount", Integer.class);

    public final NumberPath<Integer> havingProductsLikeCount = createNumber("havingProductsLikeCount", Integer.class);

    public final NumberPath<Integer> havingProductsReviewCount = createNumber("havingProductsReviewCount", Integer.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath oneLineDescription = createString("oneLineDescription");

    public final StringPath profileImage = createString("profileImage");

    public final StringPath title = createString("title");

    public QAtelier(String variable) {
        super(Atelier.class, forVariable(variable));
    }

    public QAtelier(Path<? extends Atelier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAtelier(PathMetadata metadata) {
        super(Atelier.class, metadata);
    }

}

