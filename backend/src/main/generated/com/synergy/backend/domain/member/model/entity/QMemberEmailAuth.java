package com.synergy.backend.domain.member.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEmailAuth is a Querydsl query type for MemberEmailAuth
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEmailAuth extends EntityPathBase<MemberEmailAuth> {

    private static final long serialVersionUID = 659082524L;

    public static final QMemberEmailAuth memberEmailAuth = new QMemberEmailAuth("memberEmailAuth");

    public final StringPath email = createString("email");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath uuid = createString("uuid");

    public QMemberEmailAuth(String variable) {
        super(MemberEmailAuth.class, forVariable(variable));
    }

    public QMemberEmailAuth(Path<? extends MemberEmailAuth> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEmailAuth(PathMetadata metadata) {
        super(MemberEmailAuth.class, metadata);
    }

}

