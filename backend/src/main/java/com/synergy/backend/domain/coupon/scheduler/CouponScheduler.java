package com.synergy.backend.domain.coupon.scheduler;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.coupon.service.FetchCouponWithGradeService;
import com.synergy.backend.domain.coupon.service.MemberCouponService;
import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.service.FetchGradeService;
import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.exception.BaseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class CouponScheduler {

    private final FetchMemberService fetchMemberService;
    private final FetchGradeService fetchGradeService;
    private final FetchCouponWithGradeService fetchCouponWithGradeService;
    private final MemberCouponService memberCouponService;

    public CouponScheduler(@Qualifier("fetchMemberByGradeServiceImpl") FetchMemberService fetchMemberService,
                           FetchGradeService fetchGradeService, CouponRepository couponRepository, FetchCouponWithGradeService fetchCouponWithGradeService, MemberCouponService memberCouponService) {
        this.fetchMemberService = fetchMemberService;
        this.fetchGradeService = fetchGradeService;
        this.fetchCouponWithGradeService = fetchCouponWithGradeService;
        this.memberCouponService = memberCouponService;
    }


    //    @Scheduled(cron = "0 0 0 1 * ?")
    public void issuedCoupon() throws BaseException {
                /*
        1. 전체 등급 조회
        2. 등급에 맞는 쿠폰 조회
        3. 등급에 해당하는 유저 리스트 조회
        4. 유저에게 쿠폰 발행
         */
        LocalDate now = LocalDate.now();
        LocalDateTime publicationDate = now.atStartOfDay();
        LocalDateTime expirationDate = now.plusMonths(1).atStartOfDay();

        List<Grade> grades = fetchGradeService.getGrade();
        for (Grade grade : grades) {
            Integer recurNum = grade.getRecurNum();
            Coupon coupon = fetchCouponWithGradeService.findByGradeWithRecur(grade.getIdx());
            List<Member> members = fetchMemberService.FetchMember(grade.getIdx());

            for (Member member : members) {
                for (int i = 0; i < recurNum; i++) {
                    memberCouponService.publish(publicationDate, expirationDate, member, coupon);
                }
            }
        }
    }
}
