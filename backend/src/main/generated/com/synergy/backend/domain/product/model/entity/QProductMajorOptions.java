package com.synergy.backend.domain.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductMajorOptions is a Querydsl query type for ProductMajorOptions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductMajorOptions extends EntityPathBase<ProductMajorOptions> {

    private static final long serialVersionUID = 1727961065L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductMajorOptions productMajorOptions = new QProductMajorOptions("productMajorOptions");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final QProduct product;

    public final ListPath<ProductSubOptions, QProductSubOptions> productSubOptions = this.<ProductSubOptions, QProductSubOptions>createList("productSubOptions", ProductSubOptions.class, QProductSubOptions.class, PathInits.DIRECT2);

    public QProductMajorOptions(String variable) {
        this(ProductMajorOptions.class, forVariable(variable), INITS);
    }

    public QProductMajorOptions(Path<? extends ProductMajorOptions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductMajorOptions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductMajorOptions(PathMetadata metadata, PathInits inits) {
        this(ProductMajorOptions.class, metadata, inits);
    }

    public QProductMajorOptions(Class<? extends ProductMajorOptions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

