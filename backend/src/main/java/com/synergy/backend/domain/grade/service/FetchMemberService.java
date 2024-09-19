package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.member.model.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FetchMemberService {
    public List<Member> FetchMember();
}
