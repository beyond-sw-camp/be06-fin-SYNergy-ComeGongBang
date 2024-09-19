package com.synergy.backend.domain.grade.service.impl;

import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchAllMemberServiceImpl implements FetchMemberService {

    private final MemberRepository memberRepository;

    //모든 회원 조회
    @Override
    public List<Member> FetchMember() {
        return memberRepository.findAll();
    }
}
