package com.synergy.backend.product.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.synergy.backend.hashtag.model.entity.QProductHashtag;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.model.entity.QCategory;
import com.synergy.backend.product.model.entity.QProduct;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{
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
    public List<Product> search(Long categoryIdx) {

        return queryFactory
                .selectFrom(product)
                .leftJoin(product.category, category).fetchJoin()
                .where(categoryEq(categoryIdx))
                .fetch();
    }

    @Override
    public List<Product> searchHashTag(Long hashtagIdx) {
        return queryFactory
                .selectFrom(product)
//                .leftJoin(productHashtag.product, product).fetchJoin()
                .leftJoin(productHashtag).on(productHashtag.product.eq(product))
                .where(hashTagEq(hashtagIdx))
                .fetch();
    }

    private BooleanExpression categoryEq(Long categoryIdx){
        if(categoryIdx==null){
            return null;
        }

        List<Long> categoryIds = findAllSubCategoryIds(categoryIdx);
        return product.category.idx.in(categoryIds);
    }
    private BooleanExpression hashTagEq(Long hashtagIdx){
        if(hashtagIdx==null){
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
        while(!subCategoryIds.isEmpty()){
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
