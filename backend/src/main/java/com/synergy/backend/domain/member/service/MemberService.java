package com.synergy.backend.domain.member.service;

import com.synergy.backend.domain.member.model.response.MemberInfoRes;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.domain.member.model.entity.DeliveryAddress;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.model.response.DeliveryAddressRes;
import com.synergy.backend.domain.member.repository.DeliveryAddressRepository;
import com.synergy.backend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final DeliveryAddressRepository deliveryAddressRepository;

    public String signup(MemberSignupReq memberSignupReq) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Member member = MemberSignupReq.toEntity(memberSignupReq, bCryptPasswordEncoder);
        Member result = memberRepository.save(member);

        try {
            if (result == null) {
                throw new Exception("회원 저장이 잘못되었습니다.");
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return "회원 저장 성공";
    }


    public DeliveryAddressRes getDefaultDeliveryAddress(Long userIdx) throws BaseException {
        Member member = getMember(userIdx);
        return DeliveryAddressRes.from(member.getDefaultAddress(), true);
    }

    public List<DeliveryAddressRes> getDeliveryAddressList(Long userIdx) throws BaseException {

        Member member = getMember(userIdx);
        List<DeliveryAddress> allByMemberIdx = deliveryAddressRepository.getAllByMemberIdx(userIdx);

        // 기본 배송지이면 isDefault = true, 리스트 맨 위에 존재하게
        Deque<DeliveryAddressRes> result = new LinkedList<>();

        for (DeliveryAddress deliveryAddress : allByMemberIdx) {
            Boolean isDefault = (deliveryAddress == member.getDefaultAddress());
            if (isDefault) {
                result.addFirst(DeliveryAddressRes.from(deliveryAddress, true));
            } else {
                result.add(DeliveryAddressRes.from(deliveryAddress, false));
            }
        }
        return new ArrayList<>(result);
    }

    @Transactional
    public void createDeliveryAddress(CreateDeliveryAddressReq req, Long userIdx) throws BaseException {
        //필수값 필수!
        if (Objects.equals(req.getAddress(), "")
                || Objects.equals(req.getRecipient(), "")
                || Objects.equals(req.getCellPhone(), "")) {
            throw new BaseException(BaseResponseStatus.REQUIRED_VALUE_NOT_ENTERED);
        }
        Member member = getMember(userIdx);
        DeliveryAddress saved = deliveryAddressRepository.save(req.toEntity(member));

        //기본 배송지이면 설정
        if (req.getIsDefault()) {
            member.updateDefaultAddress(saved);
            memberRepository.save(member);
        }
    }

    private Member getMember(Long userIdx) throws BaseException {
        return memberRepository.findById(userIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));
    }

    public MemberInfoRes getMemberInfo(Long idx) throws BaseException {
        Member member = memberRepository.findById(idx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));

        MemberInfoRes memberInfoRes = MemberInfoRes.from(member);

        return memberInfoRes;
    }
}
