package com.synergy.backend.domain.orders.repository;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.orders.model.response.CartDTO;
import com.synergy.backend.domain.orders.model.type.CartType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByProductIdxAndMemberIdxAndOptionSummaryAndCartType(Long memberIdx,
                                                                           Long ProductIdx,
                                                                           String optionSummary,
                                                                           CartType cartType);

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
            "    p.onSalePercent, " +
            "    p.idx, " +
            "    p.thumbnailUrl, " +
            "    a.name, " +
            "    a.idx," +
            "    c.orderMessage )" +
            "FROM Cart c " +
            "JOIN OptionInCart o ON c.idx = o.cart.idx " +
            "JOIN Product p ON c.product.idx = p.idx " +
            "JOIN Atelier a ON p.atelier.idx = a.idx " +
            "WHERE c.member.idx = :userIdx and c.cartType = :cartType")
    List<CartDTO> findByUserIdx(@Param("userIdx") Long userIdx, @Param("cartType") CartType cartType);


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
            "    p.onSalePercent, " +
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
    List<CartDTO> findByUserIdxAndCartIdx(@Param("userIdx") Long userIdx,
                                          @Param("cartList") List<Long> cartList
    );

    List<Cart> findAllByMember(Member member);

    @Query("SELECT c FROM Cart c WHERE c.member = :member AND c.cartType='DEFAULT'")
    List<Cart> findDefaultAllByMember(Member member);

    @Modifying
    @Query("DELETE FROM Cart c WHERE c.idx IN :cartIdxList")
    void deleteByCartIdxList(@Param("cartIdxList") List<Long> cartIdxList);

    @Query("SELECT c FROM Cart c WHERE c.idx IN :cartIds AND c.member = :member")
    List<Cart> findAllByIdxAndMember(@Param("cartIds") List<Long> cartIds, @Param("member") Member member);
}
