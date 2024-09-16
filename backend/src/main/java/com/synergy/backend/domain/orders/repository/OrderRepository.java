package com.synergy.backend.domain.orders.repository;

import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.entity.Present;
import com.synergy.backend.domain.orders.querydsl.OrderRepositoryCustom;
import com.synergy.backend.domain.orders.querydsl.OrderRepositoryCustomImpl;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Orders, Long> , OrderRepositoryCustom {
    List<Orders> findAllByPresentIdx(Long idx);
    @Query("SELECT o FROM Orders o JOIN FETCH o.product JOIN FETCH o.product.atelier WHERE o.present.idx = :idx")
    List<Orders> findAllByPresentIdxWithProductAndAtelier(Long idx);

}
