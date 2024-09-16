package com.synergy.backend.domain.member.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Table(name = "delivery_address")
public class DeliveryAddress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    private String recipient;
    private String address;
    private String detailAddress;
    private String postCode;
    private String addressName;
    private String cellPhone;

    public DeliveryAddress() {
    }

    @Builder
    public DeliveryAddress(Long idx, Member member, String recipient, String address, String detailAddress, String postCode, String addressName, String cellPhone) {
        this.idx = idx;
        this.member = member;
        this.recipient = recipient;
        this.address = address;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
        this.addressName = addressName;
        this.cellPhone = cellPhone;
    }


}