package com.synergy.backend.domain.orders.model.response;

import java.util.List;
import lombok.Getter;

@Getter
public class CustomData {
    List<Long> cartIds;
    Long couponIdx;
}
