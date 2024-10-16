package com.synergy.backend.domain.queue.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QueueStatus {

    private String queueIdx;
    private Long position;
    private Long backPosition;
    private Double progress;
    private Boolean isIssued;
}
