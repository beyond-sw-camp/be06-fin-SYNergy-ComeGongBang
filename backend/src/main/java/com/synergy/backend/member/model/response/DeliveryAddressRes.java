package com.synergy.backend.member.model.response;

import com.synergy.backend.member.model.entity.DeliveryAddress;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DeliveryAddressRes {

    private Long deliveryAddressIdx;
    private String recipient;
    private String address;
    private String detailAddress;
    private String postCode;
    private String addressName;
    private String cellPhone;
    private Boolean isDefault;

    @Builder
    public DeliveryAddressRes(Long deliveryAddressIdx,
                              String recipient,
                              String address,
                              String detailAddress,
                              String postCode,
                              String addressName,
                              String cellPhone,
                              Boolean isDefault) {
        this.deliveryAddressIdx = deliveryAddressIdx;
        this.recipient = recipient;
        this.address = address;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
        this.addressName = addressName;
        this.cellPhone = cellPhone;
        this.isDefault = isDefault;
    }

    public static DeliveryAddressRes from(DeliveryAddress entity, Boolean isDefault) {
        return DeliveryAddressRes
                .builder()
                .deliveryAddressIdx(entity.getIdx())
                .recipient(entity.getRecipient())
                .address(entity.getAddress())
                .detailAddress(entity.getDetailAddress())
                .postCode(entity.getPostCode())
                .addressName(entity.getAddressName())
                .cellPhone(entity.getCellPhone())
                .isDefault(isDefault)
                .build();
    }
}
