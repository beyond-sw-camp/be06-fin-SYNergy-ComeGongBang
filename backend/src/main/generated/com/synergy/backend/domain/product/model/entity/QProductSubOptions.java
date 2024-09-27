package com.synergy.backend.domain.product.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductSubOptions is a Querydsl query type for ProductSubOptions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductSubOptions extends EntityPathBase<ProductSubOptions> {

    private static final long serialVersionUID = 1988082306L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductSubOptions productSubOptions = new QProductSubOptions("productSubOptions");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final NumberPath<Integer> addPrice = createNumber("addPrice", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Integer> inventory = createNumber("inventory", Integer.class);

    public final QProductMajorOptions majorOption;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public QProductSubOptions(String variable) {
        this(ProductSubOptions.class, forVariable(variable), INITS);
    }

    public QProductSubOptions(Path<? extends ProductSubOptions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductSubOptions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductSubOptions(PathMetadata metadata, PathInits inits) {
        this(ProductSubOptions.class, metadata, inits);
    }

    public QProductSubOptions(Class<? extends ProductSubOptions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.majorOption = inits.isInitialized("majorOption") ? new QProductMajorOptions(forProperty("majorOption"), inits.get("majorOption")) : null;
    }

}

