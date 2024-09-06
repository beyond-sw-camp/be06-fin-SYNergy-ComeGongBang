package com.synergy.backend.member.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public void updateDefaultAddress(DeliveryAddress deliveryAddress) {
        this.defaultAddress = deliveryAddress;
    }
}
