package com.synergy.backend.member.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;
    private String nickname;
    private String cellPhone;
    private LocalDateTime joinDate;
    private LocalDateTime birthday;
    private String gender;
    private Boolean emailAuthentication;
    private String role;
    private String profileImageUrl;
    @ManyToOne
    @JoinColumn(name = "grade_idx")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "default_address_idx")
    private DeliveryAddress defaultAddress;
}
