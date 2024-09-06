package com.synergy.backend.member.model.request;

import com.synergy.backend.member.model.entity.DeliveryAddress;
import com.synergy.backend.member.model.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateDeliveryAddressReq {

    private String recipient;
    private String address;
    private String detailAddress;
    private String postCode;
    private String addressName;
    private String cellPhone;
    private Boolean isDefault;

    @Builder
    public CreateDeliveryAddressReq(String recipient, String address, String detailAddress, String postCode, String addressName, String cellPhone, Boolean isDefault) {
        this.recipient = recipient;
        this.address = address;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
        this.addressName = addressName;
        this.cellPhone = cellPhone;
        this.isDefault = isDefault;
    }

    public DeliveryAddress toEntity(Member member) {
        return DeliveryAddress
                .builder()
                .member(member)
                .recipient(this.recipient)
                .address(this.address)
                .detailAddress(this.detailAddress)
                .postCode(this.postCode)
                .addressName(this.addressName)
                .cellPhone(this.cellPhone)
                .build();
    }
}
