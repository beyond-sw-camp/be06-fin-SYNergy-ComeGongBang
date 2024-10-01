package com.synergy.backend.domain.orders.querydsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.synergy.backend.domain.atelier.model.entity.QAtelier;
import com.synergy.backend.domain.hashtag.model.entity.QProductHashtag;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.QOrders;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.entity.QCategory;
import com.synergy.backend.domain.product.model.entity.QProduct;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private QOrders orders;
    private QProduct product;
    private QAtelier atelier;

    public OrderRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
        this.orders = QOrders.orders;
        this.product = QProduct.product;
        this.atelier = QAtelier.atelier;
    }

    @Override
    public Page<Orders> orderList(Integer year, Pageable pageable) {
        List<Orders> result = queryFactory
                .selectFrom(orders)
                .leftJoin(orders.product, product).fetchJoin()
                .leftJoin(orders.product.atelier, atelier).fetchJoin()
                .where(yearEq(year))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory.selectFrom(orders).fetchCount();

        return new PageImpl<>(result, pageable, total);
    }

    private BooleanExpression yearEq(Integer year) {
        if (year == 0) {
            return null;
        }
        return orders.createdAt.year().eq(year);
    }
}
