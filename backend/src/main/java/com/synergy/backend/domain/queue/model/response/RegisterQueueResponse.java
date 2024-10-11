package com.synergy.backend.domain.queue.model.response;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterQueueResponse {
    String queueIdx;
    Boolean inQueue;

}
