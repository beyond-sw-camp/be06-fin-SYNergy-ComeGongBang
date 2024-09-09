package com.synergy.backend.member.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private String gender;
    private Boolean emailAuthentication;
    private String role;
    private String profileImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_idx")
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_address_idx")
    private DeliveryAddress defaultAddress;

    @Builder
    public Member(String email, String password, String nickname, String cellPhone, LocalDateTime joinDate,
                  LocalDate birthday, String gender,
                  String profileImageUrl,
                  DeliveryAddress defaultAddress) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.cellPhone = cellPhone;
        this.joinDate = joinDate;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAuthentication = false;   // 이메일 인증은 받지 못한 상태
        this.role = "USER";     // 최초 생성 USER
//        this.profileImageUrl = profileImageUrl;   // 프로필 이미지는 수정할때만
//        this.grade = "아기손"; //등급 최저
//        this.defaultAddress = defaultAddress; //기본 배송지
    }
  
    public void updateDefaultAddress(DeliveryAddress deliveryAddress) {
        this.defaultAddress = deliveryAddress;
    }
}
