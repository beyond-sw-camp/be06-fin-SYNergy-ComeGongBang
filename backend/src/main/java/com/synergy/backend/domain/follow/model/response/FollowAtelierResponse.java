package com.synergy.backend.domain.follow.model.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FollowAtelierResponse {
    //공방idx
    private Long atelierIdx;
    //공방이름
    private String atelierName;
    //공방설명
    private String atelierDescription;
    //공방이미지
    private List<String> atelierProfileImages;
}