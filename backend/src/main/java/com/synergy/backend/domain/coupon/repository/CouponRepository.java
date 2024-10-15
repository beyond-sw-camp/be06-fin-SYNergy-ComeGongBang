package com.synergy.backend.domain.coupon.repository;


import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.type.CouponType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("SELECT c FROM Coupon c WHERE c.grade.idx = :gradeId AND c.type = :type")
    Coupon findCouponsByGradeWithRecur(@Param("gradeId") Long gradeId,
                                       @Param("type") CouponType type);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Coupon c WHERE c.idx = :couponIdx")
    Optional<Coupon> findByWithPessimisticLock(@Param("couponIdx") Long couponIdx);


    @Query("SELECT c FROM Coupon c WHERE c.type = 'EVENT' " +
            "AND c.issueDate.startedAt <= CURRENT_TIMESTAMP " +
            "AND c.issueDate.finishedAt >= CURRENT_TIMESTAMP")
    List<Coupon> findByIdxWithEventCoupon();


}
