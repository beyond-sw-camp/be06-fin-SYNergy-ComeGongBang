package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import com.synergy.backend.domain.coupon.model.response.EventCouponListRes;
import com.synergy.backend.domain.coupon.model.response.MyCouponListRes;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.coupon.repository.MemberCouponRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.queue.service.QueueRedisService;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberCouponRepository memberCouponRepository;
    private final MemberRepository memberRepository;
    private final QueueRedisService queueRedisService;


    public void validateCouponIssue(Long memberIdx, Long couponIdx) throws BaseException {
        // 재고 확인
        Coupon coupon = couponRepository.findById(couponIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));
        if (!coupon.isAvailable()) {
            throw new BaseException(BaseResponseStatus.COUPON_SOLD_OUT);
        }
        // 중복 발급 확인
        if (memberCouponRepository.findByMemberIdxAndCouponIdx(memberIdx, couponIdx).isPresent()) {
            throw new BaseException(BaseResponseStatus.COUPON_ALREADY_ISSUED);
        }
        coupon.getIssueDate().validate(LocalDateTime.now());

    }


    @Transactional
    public void issueCoupon(Long memberIdx, Long couponIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        Coupon coupon = couponRepository.findByWithPessimisticLock(couponIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));

        queueRedisService.registActiveQueue(memberIdx, couponIdx);

        coupon.increaseCouponQuantity();

        MemberCoupon issued = MemberCoupon.issued(coupon, member);
        memberCouponRepository.save(issued);


    }

    public List<MyCouponListRes> getMyCouponList(Long memberIdx) throws BaseException {
        memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        LocalDateTime now = LocalDateTime.now();

        List<MemberCoupon> deleteList = memberCouponRepository.findByMemberIdx((memberIdx)).stream().filter(memberCoupon ->
                memberCoupon.getExpirationDate().isBefore(now)).toList();

        if (!deleteList.isEmpty()) {
            List<Long> list = deleteList.stream().map(memberCoupon -> memberCoupon.getIdx()).toList();
            deleteCoupon(list);
        }

        List<MyCouponListRes> list = memberCouponRepository.findByMemberIdx(memberIdx)
                .stream().map(memberCoupon ->
                        MyCouponListRes.from(memberCoupon)
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

    public List<EventCouponListRes> getEventCouponList() {
        return couponRepository.findByIdxWithEventCoupon()
                .stream().map(coupon ->
                        EventCouponListRes.from(coupon)).toList();
    }


    @Transactional
    public Long issueCoupons(String queueIdx, Long maxToMove) throws BaseException {

        List<String> waitingUsers
                = queueRedisService.getWaitingUsers(queueIdx, maxToMove);
        Long issuedCount = 0L;
        for (String membmerIdx : waitingUsers) {
            try {
                Long memberIdx = Long.parseLong(membmerIdx);
                issueCoupon(memberIdx, Long.parseLong(queueIdx.split(":")[1]));
                issuedCount++;
            } catch (BaseException e) {
                // 발급 실패 시 로깅
                log.error("Failed to issue coupon to user {}: {}", membmerIdx, e.getMessage());
            }
        }

        // 발급 성공 수 반환
        return issuedCount;
    }
}
