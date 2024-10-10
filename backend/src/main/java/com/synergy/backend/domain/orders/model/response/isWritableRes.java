package com.synergy.backend.domain.orders.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class isWritableRes {
    Boolean isWritable;
    String comment;
}
