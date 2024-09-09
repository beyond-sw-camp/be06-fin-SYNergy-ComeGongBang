package com.synergy.backend.orders.repository;


import com.synergy.backend.orders.model.entity.OptionInCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionInCartRepository extends JpaRepository<OptionInCart, Long> {
}
