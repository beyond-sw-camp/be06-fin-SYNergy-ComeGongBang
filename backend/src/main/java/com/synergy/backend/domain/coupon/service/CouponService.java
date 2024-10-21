package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import com.synergy.backend.domain.coupon.model.response.EventCouponListRes;
import com.synergy.backend.domain.coupon.model.response.MyCouponListRes;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.coupon.repository.MemberCouponRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.queue.service.CouponCacheService;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {


    private final CouponRepository couponRepository;
    private final CouponCacheService couponCacheService;
    private final MemberCouponRepository memberCouponRepository;
    private final MemberRepository memberRepository;
    private final RedissonClient redissonClient;
    private final RedisTemplate<String, String> redisTemplate;
    private static final String FINISH_KEY_PREFIX = "finish:%s";

    public void validateCouponIssue(Long memberIdx, Long couponIdx) throws BaseException {

        if (memberCouponRepository.findByMemberIdxAndCouponIdx(memberIdx, couponIdx).isPresent()) {
            throw new BaseException(BaseResponseStatus.COUPON_ALREADY_ISSUED);
        }

//        Boolean isMemberInFinishQueue = redisTemplate.opsForSet().isMember(
//                FINISH_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));
//        if (Boolean.TRUE.equals(isMemberInFinishQueue)) {
//            throw new BaseException(BaseResponseStatus.COUPON_ALREADY_ISSUED);
//        }

////        Coupon coupon = couponCacheService.getCouponFromCache(couponIdx);

        Coupon coupon = couponRepository.findById(couponIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));

        if (!coupon.isAvailable()) {
            throw new BaseException(BaseResponseStatus.COUPON_SOLD_OUT);
        }
//        coupon.getIssueDate().validate(LocalDateTime.now());

    }

    public void issueCoupon(Long memberIdx, Long couponIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        String lockKey = "lock:coupon:" + couponIdx;
        RLock lock = redissonClient.getLock(lockKey);
        try {
            lock.lock();
            Coupon coupon = couponRepository.findById(couponIdx)
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));
//        Coupon coupon = couponCacheService.getCouponFromCache(couponIdx);


            if (!coupon.isAvailable()) {
                redisTemplate.opsForValue().set("soldout:coupon:" + couponIdx, "true");
                throw new BaseException(BaseResponseStatus.COUPON_SOLD_OUT);
            }


            coupon.increaseCouponQuantity();
            couponRepository.saveAndFlush(coupon);


            MemberCoupon issued = MemberCoupon.issued(coupon, member);
            memberCouponRepository.save(issued);
        } finally {
            lock.unlock();
        }
    }

    public List<MyCouponListRes> getMyCouponList(Long memberIdx) throws BaseException {
        memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        LocalDateTime now = LocalDateTime.now();

        List<MemberCoupon> deleteList = memberCouponRepository.findByMemberIdx((memberIdx)).stream().filter(memberCoupon ->
                memberCoupon.getExpirationDate().isBefore(now)).toList();

        if (!deleteList.isEmpty()) {
            List<Long> list = deleteList.stream().map(MemberCoupon::getIdx).toList();
            deleteCoupon(list);
        }
        return memberCouponRepository.findByMemberIdx(memberIdx)
                .stream().map(MyCouponListRes::from
                ).toList();
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
                .stream().map(EventCouponListRes::from).toList();
    }

}
