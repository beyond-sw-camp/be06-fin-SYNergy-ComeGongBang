package com.synergy.backend.domain.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 482190116L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final com.synergy.backend.domain.atelier.model.entity.QAtelier atelier;

    public final NumberPath<Double> averageScore = createNumber("averageScore", Double.class);

    public final QCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> deliveryFee = createNumber("deliveryFee", Integer.class);

    public final StringPath description = createString("description");

    public final StringPath expiration = createString("expiration");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Long> likeCounts = createNumber("likeCounts", Long.class);

    public final StringPath manufacturing = createString("manufacturing");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> onSalePercent = createNumber("onSalePercent", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<com.synergy.backend.domain.hashtag.model.entity.ProductHashtag, com.synergy.backend.domain.hashtag.model.entity.QProductHashtag> productHashtagList = this.<com.synergy.backend.domain.hashtag.model.entity.ProductHashtag, com.synergy.backend.domain.hashtag.model.entity.QProductHashtag>createList("productHashtagList", com.synergy.backend.domain.hashtag.model.entity.ProductHashtag.class, com.synergy.backend.domain.hashtag.model.entity.QProductHashtag.class, PathInits.DIRECT2);

    public final ListPath<ProductImages, QProductImages> productImages = this.<ProductImages, QProductImages>createList("productImages", ProductImages.class, QProductImages.class, PathInits.DIRECT2);

    public final StringPath thumbnailUrl = createString("thumbnailUrl");

    public final StringPath type = createString("type");

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.atelier = inits.isInitialized("atelier") ? new com.synergy.backend.domain.atelier.model.entity.QAtelier(forProperty("atelier")) : null;
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category"), inits.get("category")) : null;
    }

}

