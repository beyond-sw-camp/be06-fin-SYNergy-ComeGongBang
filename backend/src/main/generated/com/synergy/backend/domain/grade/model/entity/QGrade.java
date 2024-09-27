package com.synergy.backend.domain.grade.model.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGrade is a Querydsl query type for Grade
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGrade extends EntityPathBase<Grade> {

    private static final long serialVersionUID = -626664860L;

    public static final QGrade grade = new QGrade("grade");

    public final com.synergy.backend.global.common.model.QBaseEntity _super = new com.synergy.backend.global.common.model.QBaseEntity(this);

    public final NumberPath<Integer> conditionMax = createNumber("conditionMax", Integer.class);

    public final NumberPath<Integer> conditionMin = createNumber("conditionMin", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> defaultPercent = createNumber("defaultPercent", Integer.class);

    public final NumberPath<Integer> gradeRange = createNumber("gradeRange", Integer.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final NumberPath<Integer> recurNum = createNumber("recurNum", Integer.class);

    public final NumberPath<Integer> recurPercent = createNumber("recurPercent", Integer.class);

    public final NumberPath<Integer> upgradeNum = createNumber("upgradeNum", Integer.class);

    public final NumberPath<Integer> upgradePercent = createNumber("upgradePercent", Integer.class);

    public QGrade(String variable) {
        super(Grade.class, forVariable(variable));
    }

    public QGrade(Path<? extends Grade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGrade(PathMetadata metadata) {
        super(Grade.class, metadata);
    }

}

