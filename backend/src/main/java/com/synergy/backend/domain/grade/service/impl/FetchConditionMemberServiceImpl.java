package com.synergy.backend.domain.grade.service.impl;

import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchConditionMemberServiceImpl implements FetchMemberService {

    private final MemberRepository memberRepository;

    //최근 구매이력이 있거나, 구매이력은 없지만 등급이 2이상인 회원
    @Override
    public List<Member> FetchMember() {
        LocalDateTime oneMonthTime = LocalDateTime.now().minusMonths(1).withDayOfMonth(1);
        return memberRepository.findMembersWithRecentPurchaseOrGradeAbove(oneMonthTime);
    }
}
