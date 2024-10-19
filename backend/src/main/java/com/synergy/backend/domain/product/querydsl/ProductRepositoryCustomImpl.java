package com.synergy.backend.domain.product.querydsl;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.synergy.backend.domain.atelier.model.entity.QAtelier;
import com.synergy.backend.domain.hashtag.model.entity.QProductHashtag;
import com.synergy.backend.domain.likes.model.entity.QLikes;
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
    private QLikes likes;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.entityManager = em;
        this.product = QProduct.product;
        this.category = QCategory.category;
        this.productHashtag = QProductHashtag.productHashtag;
        this.atelier = QAtelier.atelier;
        this.likes = QLikes.likes;
    }

    @Override
    public List<Product> search(String keyword, Integer price, Long memberIdx, Pageable pageable) {
        if(keyword==null || keyword.equals("")){
            return new ArrayList<>();
        }
        //키워드를 코함하는 카테고리 리스트
        List<Long> keywordCategoryIds = queryFactory
                .select(category.idx)
                .from(category)
                .where(category.categoryName.like("%" + keyword + "%"))  // 카테고리 이름에 keyword 포함
                .fetch();

        //해당 카테고리들과 관련된 하위 카테고리 리스트들
        List<Long> categoryIds = new ArrayList<>();
        for (Long idx : keywordCategoryIds) {
//            categoryIds.addAll(findAllSubCategoryIds(idx));
            categoryIds.addAll(findCategoryHierarchy(idx));
        }

        return queryFactory
                .selectFrom(product)
                .rightJoin(productHashtag).on(productHashtag.product.eq(product))
                .leftJoin(product.category, category).fetchJoin()
                .leftJoin(product.atelier, atelier).fetchJoin()
                .where(categoryEq(keyword, categoryIds).or(hashTagEq(keyword)).or(productEq(keyword)).or(atelierEq(keyword)), priceEq(price))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> searchCategory(Long categoryIdx, Integer price, Long memberIdx, Pageable pageable) {
        List<Long> categoryIds = findCategoryHierarchy(categoryIdx);

        return queryFactory
                .selectFrom(product)
                .leftJoin(product.category, category).fetchJoin()
                .leftJoin(product.atelier, atelier).fetchJoin()
//                .leftJoin(likes).on(likes.product.eq(product).and(memberEq(memberIdx)))
                .where(categoryEq(categoryIdx, categoryIds), priceEq(price))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> searchHashTag(Long hashtagIdx,Integer price, Long memberIdx, Pageable pageable) {
        return queryFactory
                .selectFrom(product)
//                .leftJoin(productHashtag.product, product).fetchJoin()
                .leftJoin(productHashtag).on(productHashtag.product.eq(product)).fetchJoin()
                .leftJoin(product.atelier, atelier).fetchJoin()
//                .leftJoin(likes).on(likes.product.eq(product).and(memberEq(memberIdx)))
                .where(hashTagEq(hashtagIdx), priceEq(price))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private BooleanExpression atelierEq(String keyword){
        if(keyword==null || keyword.equals("")){
            return null;
        }

        return atelier.name.likeIgnoreCase("%" + keyword + "%")
                .or(atelier.title.likeIgnoreCase("%" + keyword + "%"));
    }

    private BooleanExpression productEq(String keyword){
        if(keyword==null || keyword.equals("")){
            return null;
        }

        return product.name.likeIgnoreCase("%" + keyword + "%");
    }

    private BooleanExpression memberEq(Long memberIdx){
        if(memberIdx==null){
            return null;
        }

        return likes.member.idx.eq(memberIdx);
    }

    private BooleanExpression priceEq(Integer price) {
        if(price==null || price<=1){
            return null;
        }else if(price==6){
            return product.price.goe(40000);
        }
        return product.price.between((price-2)*10000 , (price-1)*10000);
    }

    private BooleanExpression categoryEq(String keyword, List<Long> categoryIds){
        if(keyword==null || keyword.equals("")){
            return null;
        }

        return product.category.idx.in(categoryIds);
    }

    private BooleanExpression categoryEq(Long categoryIdx, List<Long> categoryIds) {
        if (categoryIdx == null) {
            return null;
        }

        return product.category.idx.in(categoryIds);
    }

    private BooleanExpression hashTagEq(String keyword){
        if(keyword==null || keyword.equals("")){
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

    private List<Long> findCategoryHierarchy2(Long parentCategoryIdx) {
        List<Long> allCategoryIds = new ArrayList<>();
        allCategoryIds.add(parentCategoryIdx);
        //직접적으로 연결된 하위 카테고리 찾기
        List<Long> subCategoryIds = findSubCategoryIds(parentCategoryIdx);//1

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
