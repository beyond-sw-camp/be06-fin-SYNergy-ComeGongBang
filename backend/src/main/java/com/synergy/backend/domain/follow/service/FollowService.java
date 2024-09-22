package com.synergy.backend.domain.follow.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.follow.model.entity.Follow;
import com.synergy.backend.domain.follow.repository.FollowRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;
    private final AtelierRepository atelierRepository;

    public boolean clickFollowButton(Long memberIdx, Long atelierIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_USER));
        Atelier atelier = atelierRepository.findById(atelierIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_ATELIER));

        boolean isFollow = isFollow(member,atelier);

        // 기존 팔로우 되어있으면 해제
        if(isFollow){
            unFollow(member,atelier);
            return false;
        }
        // 팔로우 되어있지 않았으면 팔로우
        else{
            follow(member,atelier);
            return true;
        }
    }

    public boolean isFollow(Member member, Atelier atelier){
        return followRepository.existsByMemberAndAtelier(member, atelier);
    }

    // 팔로우
    // 1) 팔로우 DB에 저장
    // 2) 공방 정보에서 팔로우 수 증가
    private void follow(Member member, Atelier atelier){
        Follow follow = Follow.builder()
                .member(member)
                .atelier(atelier)
                .build();
        followRepository.save(follow);

        atelier.increaseFollowCount();
        atelierRepository.save(atelier);
    }

    // 언팔로우
    // 1) 팔로우 DB에서 삭제
    // 2) 공방 정보에서 팔로우 수 감소
    private void unFollow(Member member, Atelier atelier){
        Long followIdx = followRepository.findByMemberAndAtelier(member,atelier).get().getIdx();
        followRepository.deleteById(followIdx);

        atelier.decreaseFollowCount();
        atelierRepository.save(atelier);
    }
}
