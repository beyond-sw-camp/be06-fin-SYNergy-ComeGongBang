package com.synergy.backend.domain.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductImages is a Querydsl query type for ProductImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductImages extends EntityPathBase<ProductImages> {

    private static final long serialVersionUID = 1708598972L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductImages productImages = new QProductImages("productImages");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final QProduct product;

    public QProductImages(String variable) {
        this(ProductImages.class, forVariable(variable), INITS);
    }

    public QProductImages(Path<? extends ProductImages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductImages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductImages(PathMetadata metadata, PathInits inits) {
        this(ProductImages.class, metadata, inits);
    }

    public QProductImages(Class<? extends ProductImages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

