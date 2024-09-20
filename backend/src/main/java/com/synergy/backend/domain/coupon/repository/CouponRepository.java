package com.synergy.backend.domain.coupon.repository;


import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.type.CouponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("SELECT c FROM Coupon c WHERE c.grade.idx = :gradeId AND c.type = :type")
    Coupon findCouponsByGradeWithRecur(@Param("gradeId") Long gradeId, @Param("type") CouponType type);
}
