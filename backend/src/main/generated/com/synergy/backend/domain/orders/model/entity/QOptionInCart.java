package com.synergy.backend.domain.orders.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOptionInCart is a Querydsl query type for OptionInCart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptionInCart extends EntityPathBase<OptionInCart> {

    private static final long serialVersionUID = -210645677L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOptionInCart optionInCart = new QOptionInCart("optionInCart");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final QCart cart;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final com.synergy.backend.domain.product.model.entity.QProductMajorOptions majorOption;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final com.synergy.backend.domain.product.model.entity.QProductSubOptions subOption;

    public QOptionInCart(String variable) {
        this(OptionInCart.class, forVariable(variable), INITS);
    }

    public QOptionInCart(Path<? extends OptionInCart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOptionInCart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOptionInCart(PathMetadata metadata, PathInits inits) {
        this(OptionInCart.class, metadata, inits);
    }

    public QOptionInCart(Class<? extends OptionInCart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new QCart(forProperty("cart"), inits.get("cart")) : null;
        this.majorOption = inits.isInitialized("majorOption") ? new com.synergy.backend.domain.product.model.entity.QProductMajorOptions(forProperty("majorOption"), inits.get("majorOption")) : null;
        this.subOption = inits.isInitialized("subOption") ? new com.synergy.backend.domain.product.model.entity.QProductSubOptions(forProperty("subOption"), inits.get("subOption")) : null;
    }

}

