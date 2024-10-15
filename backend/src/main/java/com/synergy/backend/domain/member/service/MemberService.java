package com.synergy.backend.domain.member.service;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.DeliveryAddress;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.model.request.MemberUpdateReq;
import com.synergy.backend.domain.member.model.response.DeliveryAddressRes;
import com.synergy.backend.domain.member.model.response.MemberInfoRes;
import com.synergy.backend.domain.member.model.response.MemberPaymentRes;
import com.synergy.backend.domain.member.repository.DeliveryAddressRepository;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.repository.CartRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
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
    private final CartRepository cartRepository;
    private final GradeRepository gradeRepository;

    public Long isLogined(CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails == null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        return customUserDetails.getIdx();
    }

    public String signup(MemberSignupReq memberSignupReq) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Grade grade = gradeRepository.findById(1L).get();
        Member member = MemberSignupReq.toEntity(memberSignupReq, bCryptPasswordEncoder, grade);
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
    public void createDeliveryAddress(CreateDeliveryAddressReq req, Long memberIdx) throws BaseException {
        //필수값 필수!
        if (Objects.equals(req.getAddress(), "")
                || Objects.equals(req.getRecipient(), "")
                || Objects.equals(req.getCellPhone(), "")) {
            throw new BaseException(BaseResponseStatus.REQUIRED_VALUE_NOT_ENTERED);
        }

        Member member = getMember(memberIdx);
        DeliveryAddress saved = deliveryAddressRepository.save(req.toEntity(member));

        //기본 배송지이면 설정
        if (req.getIsDefault() || member.getDefaultAddress() == null) {
            member.updateDefaultAddress(saved);
            memberRepository.save(member);
        }
    }

    @Transactional
    public void deleteDelivery(Long deliveryAddressIdx, Long memberIdx) throws BaseException {


        Member member = memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        if (Objects.equals(member.getDefaultAddress().getIdx(), deliveryAddressIdx)) {
            member.updateDefaultAddress(null);
        }
        DeliveryAddress deliveryAddress = deliveryAddressRepository.findById(deliveryAddressIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_DELIVERY_ADDRESS));

        deliveryAddressRepository.delete(deliveryAddress);

        List<DeliveryAddress> allByMemberIdx = deliveryAddressRepository.getAllByMemberIdx(memberIdx);


        if (allByMemberIdx.size() != 0) {
            member.updateDefaultAddress(allByMemberIdx.get(0));
            memberRepository.save(member);
        }


    }

    private Member getMember(Long userIdx) throws BaseException {
        return memberRepository.findById(userIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));
    }

    public MemberInfoRes getMemberInfo(Long idx) throws BaseException {
        Member member = memberRepository.findById(idx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        int size = cartRepository.findDefaultAllByMember(member).size();

        MemberInfoRes memberInfoRes = MemberInfoRes.from(member,size);

        return memberInfoRes;
    }

    public MemberInfoRes updateMemberInfo(Long memberIdx, MemberUpdateReq req) throws BaseException {
        Member member = getMember(memberIdx);
        member.changeMemberInfo(req);

        Member newMember = memberRepository.save(member);
        int productsInCartCount = cartRepository.findAllByMember(member).size();

        MemberInfoRes memberInfoRes = MemberInfoRes.from(newMember, productsInCartCount);

        return memberInfoRes;
    }

    public void isExistMember(String email) throws BaseException {
        if (memberRepository.findByEmail(email).isPresent()) {
            throw new BaseException(BaseResponseStatus.ALREADY_EXIST_MEMBER);
        }
    }

    public Boolean isMember(String memberEmail) {
        Optional<Member> member = memberRepository.findByEmail(memberEmail);
        if(member.isPresent()){
            return true;
        }
        return false;
    }

    @Transactional
    public String deleteMember(Long memberIdx) throws BaseException {
        memberRepository.deleteById(memberIdx);

        Optional<Member> member = memberRepository.findById(memberIdx);
        if(member.isEmpty()){
            return "회원 탈퇴에 성공하였습니다.";
        }
        throw new BaseException(BaseResponseStatus.CANNOT_DELETE_MEMBER);

    }

    public MemberPaymentRes getMemberPaymentInfo(Long idx) {
        return memberRepository.findMemberPaymentInfoByMemberIdx(idx);
    }
}

