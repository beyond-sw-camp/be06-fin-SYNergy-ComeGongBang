package com.synergy.backend.domain.coupon.repository;

import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

}
