package com.synergy.backend.domain.member.model.response;

import com.synergy.backend.domain.grade.model.entity.Grade;
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

    //등급정보
    private Long gradeIdx;
    private String gradeName;
    private String gradeImageUrl;

    //장바구니 정보
    private int productsInCartCount;

    @Builder
    public MemberInfoRes(Long idx, String nickname, String email, String cellphone, LocalDate birthday,
                         String profileImageUrl, Long gradeIdx, String gradeName, String gradeImageUrl,int productsInCartCount) {
        this.idx = idx;
        this.nickname = nickname;
        this.email = email;
        this.cellphone = cellphone;
        this.birthday = birthday;
        this.profileImageUrl = profileImageUrl;
        this.gradeIdx = gradeIdx;
        this.gradeName = gradeName;
        this.gradeImageUrl = gradeImageUrl;
        this.productsInCartCount = productsInCartCount;
    }

    public static MemberInfoRes from(Member member) {
        return MemberInfoRes.builder()
                .idx(member.getIdx())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .cellphone(member.getCellPhone())
                .birthday(member.getBirthday())
                .profileImageUrl(member.getProfileImageUrl())
                .gradeIdx(member.getGrade().getIdx())
                .gradeName(member.getGrade().getName())
                .gradeImageUrl(member.getGrade().getImageUrl())
                .build();
    }

    public static MemberInfoRes from(Member member, int productsInCartCount) {
        return MemberInfoRes.builder()
                .idx(member.getIdx())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .cellphone(member.getCellPhone())
                .birthday(member.getBirthday())
                .profileImageUrl(member.getProfileImageUrl())
                .gradeIdx(member.getGrade().getIdx())
                .gradeName(member.getGrade().getName())
                .gradeImageUrl(member.getGrade().getImageUrl())
                .productsInCartCount(productsInCartCount)
                .build();
    }
}
