package com.synergy.backend.domain.follow.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.repository.AtelierProfileImagesRepository;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.follow.model.entity.Follow;
import com.synergy.backend.domain.follow.model.response.FollowAtelierResponse;
import com.synergy.backend.domain.follow.model.response.FollowInfoResponse;
import com.synergy.backend.domain.follow.repository.FollowRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;
    private final AtelierRepository atelierRepository;
    private final AtelierProfileImagesRepository atelierProfileImagesRepository;

    public FollowInfoResponse clickFollowButton(Long memberIdx, Long atelierIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));
        Atelier atelier = atelierRepository.findById(atelierIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_ATELIER));

        boolean isFollow = isFollow(member,atelier);

        FollowInfoResponse followInfoResponse;
        // 기존 팔로우 되어있으면 해제
        if(isFollow){
            unFollow(member,atelier);
            followInfoResponse = FollowInfoResponse.builder()
                    .memberIsFollow(false)
                    .havingFollowerCount(atelier.getHavingFollowerCount())
                    .build();
            return followInfoResponse;
        }
        // 팔로우 되어있지 않았으면 팔로우
        else{
            follow(member,atelier);
            followInfoResponse = FollowInfoResponse.builder()
                    .memberIsFollow(true)
                    .havingFollowerCount(atelier.getHavingFollowerCount())
                    .build();
            return followInfoResponse;
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

    public List<FollowAtelierResponse> getFollowAtelierList(Long memberIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        List<Atelier> atelierList = followRepository.findFollowAtelierByMember(member);

        List<FollowAtelierResponse> response = new ArrayList<>();
        for(Atelier a : atelierList){
            FollowAtelierResponse followAtelier = FollowAtelierResponse.builder()
                    .atelierIdx(a.getIdx())
                    .atelierName(a.getName())
                    .atelierDescription(a.getOneLineDescription())
                    .atelierProfileImages(atelierProfileImagesRepository.findAllByAtelier(a))
                    .build();
            response.add(followAtelier);
        }
        return response;
    }
}
