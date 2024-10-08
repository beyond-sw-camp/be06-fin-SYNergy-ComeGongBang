package com.synergy.backend.domain.coupon.repository;

import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    Optional<MemberCoupon> findByMemberIdxAndCouponIdx(Long memberIdx, Long couponIdx);

    List<MemberCoupon> findByMemberIdx(Long memberIdx);

    @Query("delete from MemberCoupon where idx in :memberCouponIdx")
    void deleteAllByIdx(@Param("memberCouponIdx") List<Long> memberCouponIdx);


}
