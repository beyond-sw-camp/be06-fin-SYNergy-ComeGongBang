package com.synergy.backend.domain.grade.service.impl;

import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchMemberByGradeServiceImpl implements FetchMemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<Member> FetchMember() {
        return List.of();
    }

    @Override
    public List<Member> FetchMember(Long gradeIdx) {
        return memberRepository.findByGradeIdx(gradeIdx);
    }
}
