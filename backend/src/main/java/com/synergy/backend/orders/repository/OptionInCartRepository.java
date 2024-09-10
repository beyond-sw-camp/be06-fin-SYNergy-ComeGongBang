package com.synergy.backend.orders.repository;


import com.synergy.backend.orders.model.entity.OptionInCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OptionInCartRepository extends JpaRepository<OptionInCart, Long> {

    List<OptionInCart> findByCartIdx(Long cartIdx);
}
