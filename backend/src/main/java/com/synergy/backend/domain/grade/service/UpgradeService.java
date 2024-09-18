package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpgradeService {

    private final MemberRepository memberRepository;

    public void changeGrade(Member member, Grade grade) throws BaseException {
        member.changeGrade(grade);
        memberRepository.save(member);
    }
}
