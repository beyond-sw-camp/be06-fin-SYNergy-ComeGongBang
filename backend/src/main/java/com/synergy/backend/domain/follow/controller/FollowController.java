package com.synergy.backend.domain.follow.controller;

import com.synergy.backend.domain.follow.model.response.FollowAtelierResponse;
import com.synergy.backend.domain.follow.model.response.FollowInfoResponse;
import com.synergy.backend.domain.follow.service.FollowService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {
    private final FollowService followService;

    @PostMapping("click")
    public BaseResponse<FollowInfoResponse> clickFollowButton(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody Map<String, Long> atelierIdx) throws BaseException {
        Long memberIdx = customUserDetails.getIdx();
        Long getAtelierIdx = atelierIdx.get("atelierIdx");

        FollowInfoResponse result = followService.clickFollowButton(memberIdx, getAtelierIdx);
        return new BaseResponse<>(result);
    }

    @GetMapping("/list")
    public BaseResponse<List<FollowAtelierResponse>> followList(
            @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if (customUserDetails == null) {
            return new BaseResponse<>(new ArrayList<>());
        }
        Long memberIdx = customUserDetails.getIdx();

        return new BaseResponse<>(followService.getFollowAtelierList(memberIdx));
    }
}

