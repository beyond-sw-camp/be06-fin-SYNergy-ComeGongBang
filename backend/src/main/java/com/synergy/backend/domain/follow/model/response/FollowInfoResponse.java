package com.synergy.backend.domain.follow.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowInfoResponse {
    private boolean memberIsFollow;
    private int havingFollowerCount;
}
