package com.synergy.backend.domain.orders.repository;


import com.synergy.backend.domain.orders.model.entity.OptionInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionInCartRepository extends JpaRepository<OptionInCart, Long> {

    List<OptionInCart> findByCartIdx(Long cartIdx);

    @Modifying
    @Query("DELETE FROM OptionInCart oc WHERE oc.cart.idx IN :cartIdxList")
    void deleteAllByCartIdx(@Param("cartIdxList") List<Long> cartIdxList);
}
