package com.synergy.backend.orders.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubOptionsRes {
    private String majorOptionName;
    private Long majorOptionIdx;
    private String subOptionName;
    private Long subOptionIdx;
}
