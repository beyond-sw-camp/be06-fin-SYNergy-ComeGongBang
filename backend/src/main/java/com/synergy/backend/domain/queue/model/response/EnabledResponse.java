package com.synergy.backend.domain.queue.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EnabledResponse {
    Boolean isEnable;
}
