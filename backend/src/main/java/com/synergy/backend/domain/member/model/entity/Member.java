package com.synergy.backend.domain.member.model.entity;

import com.synergy.backend.domain.follow.model.entity.Follow;
import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.likes.model.entity.Likes;
import com.synergy.backend.domain.member.model.request.MemberUpdateReq;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;
    private String nickname;
    private String cellPhone;
    private LocalDateTime joinDate;
    private LocalDate birthday;
    private Boolean emailAuthentication;
    private String role;
    private String profileImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_idx")
    private Grade grade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_address_idx")
    private DeliveryAddress defaultAddress;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DeliveryAddress> deliveryAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Follow> follows = new ArrayList<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cart> carts = new ArrayList<>();

    @Builder
    public Member(Long idx, String email, String password, String nickname, String cellPhone, LocalDateTime joinDate,
                  LocalDate birthday, String profileImageUrl, Grade grade) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.cellPhone = cellPhone;
        this.joinDate = joinDate;
        this.birthday = birthday;
        this.emailAuthentication = false;   // 이메일 인증은 받지 못한 상태
        this.role = "ROLE_USER";     // 최초 생성 USER
        this.profileImageUrl = profileImageUrl;
        this.grade = grade;
    }

    public Member(Long idx, String username, String role) {
        this.idx = idx;
        this.email = username;
        this.role = role;
    }

    public void changeMemberInfo(MemberUpdateReq req) {
        this.nickname = req.getNickname();
    }

    public void updateDefaultAddress(DeliveryAddress deliveryAddress) {
        this.defaultAddress = deliveryAddress;
    }

    public void changeGrade(Grade grade) {
        this.grade = grade;
    }
}
