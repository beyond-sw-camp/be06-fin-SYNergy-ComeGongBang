package com.synergy.backend.domain.orders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCartOption {
    private Long majorOption;
    private Long subOption;
}
