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
    private Long majorOptionName;
    private Long majorOptionIdx;
    private Long subOptionName;
    private Long subOptionIdx;
}
