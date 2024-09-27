package com.synergy.backend.domain.orders.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPresent is a Querydsl query type for Present
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPresent extends EntityPathBase<Present> {

    private static final long serialVersionUID = -291235198L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPresent present = new QPresent("present");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath addressDetail = createString("addressDetail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.synergy.backend.domain.member.model.entity.QMember fromMember;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath message = createString("message");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final com.synergy.backend.domain.member.model.entity.QMember toMember;

    public QPresent(String variable) {
        this(Present.class, forVariable(variable), INITS);
    }

    public QPresent(Path<? extends Present> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPresent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPresent(PathMetadata metadata, PathInits inits) {
        this(Present.class, metadata, inits);
    }

    public QPresent(Class<? extends Present> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fromMember = inits.isInitialized("fromMember") ? new com.synergy.backend.domain.member.model.entity.QMember(forProperty("fromMember"), inits.get("fromMember")) : null;
        this.toMember = inits.isInitialized("toMember") ? new com.synergy.backend.domain.member.model.entity.QMember(forProperty("toMember"), inits.get("toMember")) : null;
    }

}

