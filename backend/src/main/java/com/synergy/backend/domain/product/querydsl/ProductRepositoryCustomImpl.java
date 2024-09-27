package com.synergy.backend.domain.product.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.synergy.backend.domain.atelier.model.entity.QAtelier;
import com.synergy.backend.domain.hashtag.model.entity.QProductHashtag;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.QCategory;
import com.synergy.backend.domain.product.model.entity.QProduct;
import com.synergy.backend.domain.product.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;
    private QProduct product;
    private QCategory category;
    private QProductHashtag productHashtag;
    private QAtelier atelier;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.entityManager = em;
        this.product = QProduct.product;
        this.category = QCategory.category;
        this.productHashtag = QProductHashtag.productHashtag;
        this.atelier = QAtelier.atelier;
    }

    @Override
    public List<Product> search(String keyword, Pageable pageable) {
        return queryFactory
                .selectFrom(product)
                .leftJoin(productHashtag).on(productHashtag.product.eq(product))
                .leftJoin(product.category, category).fetchJoin()
                .leftJoin(product.atelier, atelier).fetchJoin()
                .where(hashTagEq(keyword).or(atelierEq(keyword)).or(productEq(keyword)).or(categoryEq(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> searchCategory(Long categoryIdx, Pageable pageable) {

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

    private BooleanExpression atelierEq(String keyword){
        if(keyword==null){
            return null;
        }

        return atelier.name.likeIgnoreCase("%" + keyword + "%")
                .or(atelier.title.likeIgnoreCase("%" + keyword + "%"));
    }

    private BooleanExpression productEq(String keyword){
        if(keyword==null){
            return null;
        }

        return product.name.likeIgnoreCase("%" + keyword + "%");
    }

    private BooleanExpression categoryEq(String keyword){
        if(keyword==null){
            return null;
        }

        List<Long> keywordCategoryIds = queryFactory
                .select(category.idx)
                .from(category)
                .where(category.categoryName.likeIgnoreCase("%" + keyword + "%"))  // 카테고리 이름에 keyword 포함
                .fetch();

        List<Long> categoryIds = new ArrayList<>();
        for (Long idx : keywordCategoryIds) {
//            categoryIds.addAll(findAllSubCategoryIds(idx));
            categoryIds.addAll(findCategoryHierarchy(idx));
        }

        return product.category.idx.in(categoryIds);
    }

    private BooleanExpression categoryEq(Long categoryIdx) {
        if (categoryIdx == null) {
            return null;
        }

//        List<Long> categoryIds = findAllSubCategoryIds(categoryIdx);
        List<Long> categoryIds = findCategoryHierarchy(categoryIdx);
        return product.category.idx.in(categoryIds);
    }

    private BooleanExpression hashTagEq(String keyword){
        if(keyword==null){
            return null;
        }

        return productHashtag.hashtag.name.likeIgnoreCase("%" + keyword + "%");
    }

    private BooleanExpression hashTagEq(Long hashtagIdx) {
        if (hashtagIdx == null) {
            return null;
        }

        return productHashtag.hashtag.idx.eq(hashtagIdx);
    }

    private List<Long> findCategoryHierarchy(Long parentCategoryIdx) {
        String query = """
        WITH RECURSIVE category_hierarchy AS (
            SELECT idx, parent_idx, category_name
            FROM category
            WHERE idx = ?1
            UNION ALL
            SELECT c.idx, c.parent_idx, c.category_name
            FROM category c
            INNER JOIN category_hierarchy ch ON c.parent_idx = ch.idx
        )
        SELECT idx FROM category_hierarchy
        """;

        List<Long> categoryIds = entityManager.createNativeQuery(query)
                .setParameter(1, parentCategoryIdx)
                .getResultList();

        return categoryIds;
    }

//    private List<Long> findAllSubCategoryIds(Long parentCategoryIdx) {
//        List<Long> allCategoryIds = new ArrayList<>();
//        allCategoryIds.add(parentCategoryIdx);
//        //직접적으로 연결된 하위 카테고리 찾기
//        List<Long> subCategoryIds = findSubCategoryIds(parentCategoryIdx);
//
//        //모든 categoryIds에 대해 각각 다시 subcategories를 찾고 카테고리 목록에 추가하는 반복문
//        while (!subCategoryIds.isEmpty()) {
//            List<Long> newIds = new ArrayList<>();
//            for (Long ids : subCategoryIds) {
//                allCategoryIds.add(ids);
//                newIds.addAll(findSubCategoryIds(ids));
//            }
//            subCategoryIds = newIds;
//        }
//
//        return allCategoryIds;
//    }
//
//    private List<Long> findSubCategoryIds(Long parentCategoryIdx) {
//        // 상위 카테고리와 직접적으로 연결된 하위 카테고리 찾기
//        List<Long> subCategoryIds = queryFactory
//                .select(category.idx)
//                .from(category)
//                .where(category.parentCategory.idx.eq(parentCategoryIdx))
//                .fetch();
//
//        return subCategoryIds;
//    }
}
