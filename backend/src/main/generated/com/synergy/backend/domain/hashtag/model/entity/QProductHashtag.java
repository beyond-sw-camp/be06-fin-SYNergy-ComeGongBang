package com.synergy.backend.domain.hashtag.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductHashtag is a Querydsl query type for ProductHashtag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductHashtag extends EntityPathBase<ProductHashtag> {

    private static final long serialVersionUID = -1348939419L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductHashtag productHashtag = new QProductHashtag("productHashtag");

    public final QHashtag hashtag;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final com.synergy.backend.domain.product.model.entity.QProduct product;

    public QProductHashtag(String variable) {
        this(ProductHashtag.class, forVariable(variable), INITS);
    }

    public QProductHashtag(Path<? extends ProductHashtag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductHashtag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductHashtag(PathMetadata metadata, PathInits inits) {
        this(ProductHashtag.class, metadata, inits);
    }

    public QProductHashtag(Class<? extends ProductHashtag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hashtag = inits.isInitialized("hashtag") ? new QHashtag(forProperty("hashtag")) : null;
        this.product = inits.isInitialized("product") ? new com.synergy.backend.domain.product.model.entity.QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

