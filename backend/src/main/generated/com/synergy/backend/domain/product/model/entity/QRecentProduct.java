package com.synergy.backend.domain.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecentProduct is a Querydsl query type for RecentProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecentProduct extends EntityPathBase<RecentProduct> {

    private static final long serialVersionUID = -2043548535L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecentProduct recentProduct = new QRecentProduct("recentProduct");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final com.synergy.backend.domain.member.model.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final QProduct product;

    public QRecentProduct(String variable) {
        this(RecentProduct.class, forVariable(variable), INITS);
    }

    public QRecentProduct(Path<? extends RecentProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecentProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecentProduct(PathMetadata metadata, PathInits inits) {
        this(RecentProduct.class, metadata, inits);
    }

    public QRecentProduct(Class<? extends RecentProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.synergy.backend.domain.member.model.entity.QMember(forProperty("member"), inits.get("member")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

