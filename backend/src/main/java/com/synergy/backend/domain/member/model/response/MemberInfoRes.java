package com.synergy.backend.domain.member.model.response;

import com.synergy.backend.domain.member.model.entity.Member;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfoRes {

    private Long idx;
    private String nickname;
    private String email;
    private String cellphone;
    private LocalDate birthday;
    private String profileImageUrl;

    @Builder
    public MemberInfoRes(Long idx, String nickname, String email, String cellphone, LocalDate birthday,
                         String profileImageUrl) {
        this.idx = idx;
        this.nickname = nickname;
        this.email = email;
        this.cellphone = cellphone;
        this.birthday = birthday;
        this.profileImageUrl = profileImageUrl;
    }

    public static MemberInfoRes from(Member member) {
        return MemberInfoRes.builder()
                .idx(member.getIdx())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .cellphone(member.getCellPhone())
                .birthday(member.getBirthday())
                .profileImageUrl(member.getProfileImageUrl())
                .build();
    }
}
