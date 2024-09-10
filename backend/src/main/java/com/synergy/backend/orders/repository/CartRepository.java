package com.synergy.backend.orders.repository;

import com.synergy.backend.orders.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
