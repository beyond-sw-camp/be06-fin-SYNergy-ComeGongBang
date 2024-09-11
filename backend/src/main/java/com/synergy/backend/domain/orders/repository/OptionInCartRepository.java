package com.synergy.backend.domain.orders.repository;


import com.synergy.backend.domain.orders.model.entity.OptionInCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionInCartRepository extends JpaRepository<OptionInCart, Long> {

    List<OptionInCart> findByCartIdx(Long cartIdx);
}
