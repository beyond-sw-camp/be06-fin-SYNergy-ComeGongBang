package com.synergy.backend.domain.orders.repository;

import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.querydsl.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>, OrderRepositoryCustom {
    List<Orders> findAllByPresentIdx(Long idx);

    @Query("SELECT o FROM Orders o JOIN FETCH o.product JOIN FETCH o.product.atelier WHERE o.present.idx = :idx")
    List<Orders> findAllByPresentIdxWithProductAndAtelier(Long idx);


    @Query("SELECT SUM(o.totalPrice) FROM Orders o " +
            "WHERE o.member.idx = :memberIdx " +
            "AND o.paymentState = '결제완료' " +
            "AND o.deliveryState = '배송완료' " +
            "AND o.createdAt BETWEEN :startDate AND :endDate")
    Integer findTotalAmountByMemberIdAndDateRange(
            @Param("memberIdx") Long memberIdx,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );


    Boolean existsByIdxAndMemberIdx(Long orderIdx, Long memberidx);
}
