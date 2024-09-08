package com.synergy.backend.member.service;

import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.model.request.MemberSignupReq;
import com.synergy.backend.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String signup(MemberSignupReq memberSignupReq) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Member member = MemberSignupReq.toEntity(memberSignupReq,bCryptPasswordEncoder);
        Member result = memberRepository.save(member);

        try{
            if(result == null){
                throw new Exception("회원 저장이 잘못되었습니다.");
            }
        }catch (Exception e){
            return e.getMessage();
        }

        return "회원 저장 성공";
    }
}
