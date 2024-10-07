package com.synergy.backend.domain.coupon.repository;

import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    Optional<MemberCoupon> findByMemberIdxAndCouponIdx(Long memberIdx, Long couponIdx);

    List<MemberCoupon> findByMemberIdx(Long memberIdx);


}
