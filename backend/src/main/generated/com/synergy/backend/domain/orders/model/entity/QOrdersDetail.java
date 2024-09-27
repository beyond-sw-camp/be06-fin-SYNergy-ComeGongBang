package com.synergy.backend.domain.orders.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrdersDetail is a Querydsl query type for OrdersDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrdersDetail extends EntityPathBase<OrdersDetail> {

    private static final long serialVersionUID = -1094432209L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrdersDetail ordersDetail = new QOrdersDetail("ordersDetail");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final QOrders order;

    public final NumberPath<Integer> productCount = createNumber("productCount", Integer.class);

    public final com.synergy.backend.domain.product.model.entity.QProductSubOptions productSubOption;

    public QOrdersDetail(String variable) {
        this(OrdersDetail.class, forVariable(variable), INITS);
    }

    public QOrdersDetail(Path<? extends OrdersDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrdersDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrdersDetail(PathMetadata metadata, PathInits inits) {
        this(OrdersDetail.class, metadata, inits);
    }

    public QOrdersDetail(Class<? extends OrdersDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrders(forProperty("order"), inits.get("order")) : null;
        this.productSubOption = inits.isInitialized("productSubOption") ? new com.synergy.backend.domain.product.model.entity.QProductSubOptions(forProperty("productSubOption"), inits.get("productSubOption")) : null;
    }

}

