package com.synergy.backend.orders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddCartOption {
    private Long majorOption;
    private Long subOption;
}
