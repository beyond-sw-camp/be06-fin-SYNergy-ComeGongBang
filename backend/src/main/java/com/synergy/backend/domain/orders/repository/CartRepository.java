package com.synergy.backend.domain.orders.repository;

import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.response.CartDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> getCartsByProductIdx(Long productIdx);

    @Query("SELECT new com.synergy.backend.domain.orders.model.response.CartDTO( " +
            "    c.idx, " +
            "    o.idx, " +
            "    o.majorOption.idx, " +
            "    o.majorOption.name, " +
            "    o.subOption.idx, " +
            "    o.subOption.name, " +
            "    c.count, " +
            "    c.price, " +
            "    p.name, " +
            "    p.idx, " +
            "    p.thumbnailUrl, " +
            "    a.name, " +
            "    a.idx," +
            "    c.orderMessage )" +
            "FROM Cart c " +
            "JOIN OptionInCart o ON c.idx = o.cart.idx " +
            "JOIN Product p ON c.product.idx = p.idx " +
            "JOIN Atelier a ON p.atelier.idx = a.idx " +
            "WHERE c.member.idx = :userIdx")
    List<CartDTO> findByUserIdx(@Param("userIdx") Long userIdx);


    @Query("SELECT new com.synergy.backend.domain.orders.model.response.CartDTO( " +
            "    c.idx, " +
            "    o.idx, " +
            "    o.majorOption.idx, " +
            "    o.majorOption.name, " +
            "    o.subOption.idx, " +
            "    o.subOption.name, " +
            "    c.count, " +
            "    c.price, " +
            "    p.name, " +
            "    p.idx, " +
            "    p.thumbnailUrl, " +
            "    a.name, " +
            "    a.idx," +
            "    c.orderMessage )" +
            "FROM Cart c " +
            "JOIN OptionInCart o ON c.idx = o.cart.idx " +
            "JOIN Product p ON c.product.idx = p.idx " +
            "JOIN Atelier a ON p.atelier.idx = a.idx " +
            "WHERE c.member.idx = :userIdx " +
            "AND c.idx in :cartList")
    List<CartDTO> findByUserIdxAndCartIdx(@Param("userIdx") Long userIdx, @Param("cartList") List<Long> cartList);
}
