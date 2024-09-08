package com.synergy.backend.global.security;

import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> result = memberRepository.findByEmail(username);

        if(result.isEmpty()){
//            throw new UsernameNotFoundException("해당 이메일이 존재하지 않습니다.");
            System.out.println("해당 이메일이 존재하지 않습니다.");
            return null;
        }
        return new CustomUserDetails(result.get());
    }
}
