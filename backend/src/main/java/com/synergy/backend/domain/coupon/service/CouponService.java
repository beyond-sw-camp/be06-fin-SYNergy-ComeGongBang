package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import com.synergy.backend.domain.coupon.model.response.CouponListRes;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.coupon.repository.MemberCouponRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberCouponRepository memberCouponRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void issueCoupon(Long memberIdx, Long couponIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        Coupon coupon = couponRepository.findByWithPessimisticLock(couponIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));

        if (memberCouponRepository.findByMemberIdxAndCouponIdx(memberIdx, couponIdx).isPresent()) {
            throw new BaseException(BaseResponseStatus.COUPON_ALREADY_ISSUED);
        }

        if (!coupon.isAvailable()) {
            throw new BaseException(BaseResponseStatus.COUPON_SOLD_OUT);
        }
        coupon.getIssueDate().validate(LocalDateTime.now());

        coupon.increaseCouponQuantity();

        MemberCoupon issued = MemberCoupon.issued(coupon, member);
        memberCouponRepository.save(issued);


    }

    public List<CouponListRes> getMyCouponList(Long memberIdx) throws BaseException {
        memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        LocalDateTime now = LocalDateTime.now();

        List<MemberCoupon> deleteList = memberCouponRepository.findByMemberIdx((memberIdx)).stream().filter(memberCoupon ->
                memberCoupon.getExpirationDate().isBefore(now)).toList();

        if (!deleteList.isEmpty()) {
            List<Long> list = deleteList.stream().map(memberCoupon -> memberCoupon.getIdx()).toList();
            deleteCoupon(list);
        }

        List<CouponListRes> list = memberCouponRepository.findByMemberIdx(memberIdx)
                .stream().map(memberCoupon ->
                        CouponListRes.from(memberCoupon)
                ).toList();



        return list;
    }

    public void deleteCoupon(List<Long> memberCouponIdx) throws BaseException {
        try {
            memberCouponRepository.deleteAllByIdx(memberCouponIdx);
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAIL_DELETE_MEMBER_COUPON);
        }
    }
}
