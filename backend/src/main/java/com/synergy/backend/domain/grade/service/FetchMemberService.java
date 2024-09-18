package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchMemberService {

    private final MemberRepository memberRepository;

    public List<Member> FetchMember() {


        return null;
    }
}
