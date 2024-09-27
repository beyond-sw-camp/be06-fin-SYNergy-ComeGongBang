package com.synergy.backend.domain.product.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.synergy.backend.domain.hashtag.model.entity.QProductHashtag;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.QCategory;
import com.synergy.backend.domain.product.model.entity.QProduct;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private QProduct product;
    private QCategory category;
    private QProductHashtag productHashtag;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.product = QProduct.product;
        this.category = QCategory.category;
        this.productHashtag = QProductHashtag.productHashtag;
    }

    @Override
    public List<Product> search(Long categoryIdx, Pageable pageable) {

        return queryFactory
                .selectFrom(product)
                .leftJoin(product.category, category).fetchJoin()
                .where(categoryEq(categoryIdx))
                .offset(pageable.getOffset()) //페이징에서 시작 위치를 설정
                .limit(pageable.getPageSize()) //페이징에서 가져올 데이터의 개수를 제한
                .fetch();
    }

    @Override
    public List<Product> searchHashTag(Long hashtagIdx, Pageable pageable) {
        return queryFactory
                .selectFrom(product)
//                .leftJoin(productHashtag.product, product).fetchJoin()
                .leftJoin(productHashtag).on(productHashtag.product.eq(product))
                .where(hashTagEq(hashtagIdx))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private BooleanExpression categoryEq(Long categoryIdx) {
        if (categoryIdx == null) {
            return null;
        }

        List<Long> categoryIds = findAllSubCategoryIds(categoryIdx);
        return product.category.idx.in(categoryIds);
    }

    private BooleanExpression hashTagEq(Long hashtagIdx) {
        if (hashtagIdx == null) {
            return null;
        }

        return productHashtag.hashtag.idx.eq(hashtagIdx);
    }

    private List<Long> findAllSubCategoryIds(Long parentCategoryIdx) {
        List<Long> allCategoryIds = new ArrayList<>();
        allCategoryIds.add(parentCategoryIdx);
        //직접적으로 연결된 하위 카테고리 찾기
        List<Long> subCategoryIds = findSubCategoryIds(parentCategoryIdx);

        //모든 categoryIds에 대해 각각 다시 subcategories를 찾고 카테고리 목록에 추가하는 반복문
        while (!subCategoryIds.isEmpty()) {
            List<Long> newIds = new ArrayList<>();
            for (Long ids : subCategoryIds) {
                allCategoryIds.add(ids);
                newIds.addAll(findSubCategoryIds(ids));
            }
            subCategoryIds = newIds;
        }

        return allCategoryIds;
    }

    private List<Long> findSubCategoryIds(Long parentCategoryIdx) {
        // 상위 카테고리와 직접적으로 연결된 하위 카테고리 찾기
        List<Long> subCategoryIds = queryFactory
                .select(category.idx)
                .from(category)
                .where(category.parentCategory.idx.eq(parentCategoryIdx))
                .fetch();

        return subCategoryIds;
    }
}
