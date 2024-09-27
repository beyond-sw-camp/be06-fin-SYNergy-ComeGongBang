package com.synergy.backend.domain.ask.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAsk is a Querydsl query type for Ask
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAsk extends EntityPathBase<Ask> {

    private static final long serialVersionUID = 679090404L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAsk ask = new QAsk("ask");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final BooleanPath isSecret = createBoolean("isSecret");

    public final com.synergy.backend.domain.member.model.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final com.synergy.backend.domain.product.model.entity.QProduct product;

    public final QReply reply;

    public QAsk(String variable) {
        this(Ask.class, forVariable(variable), INITS);
    }

    public QAsk(Path<? extends Ask> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAsk(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAsk(PathMetadata metadata, PathInits inits) {
        this(Ask.class, metadata, inits);
    }

    public QAsk(Class<? extends Ask> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.synergy.backend.domain.member.model.entity.QMember(forProperty("member"), inits.get("member")) : null;
        this.product = inits.isInitialized("product") ? new com.synergy.backend.domain.product.model.entity.QProduct(forProperty("product"), inits.get("product")) : null;
        this.reply = inits.isInitialized("reply") ? new QReply(forProperty("reply"), inits.get("reply")) : null;
    }

}

