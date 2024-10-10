package com.synergy.backend.domain.queue.controller;

import com.synergy.backend.domain.queue.model.response.EnabledResponse;
import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.domain.queue.service.QueueService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/queue")
@RestController
public class QueueController {

    private final QueueService queueService;


    /**
     * 사용자를 대기열에 등록
     *
     * @param programId
     * @param customUserDetails
     * @return queueId와 대기열 진입 여부
     */
    @PostMapping
    public BaseResponse<RegisterQueueResponse> registerQueue(@RequestParam Long programId,
                                                             @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {

        RegisterQueueResponse registerQueueResponse
                = queueService.enterQueue(programId, customUserDetails.getIdx());

        return new BaseResponse<>(registerQueueResponse);
    }

    /**
     * 대기열 현재 위치 확인
     *
     * @param queueId
     * @param customUserDetails
     * @return 대기열 현재 위치
     */
    @GetMapping("/rank")
    public BaseResponse<QueueStatus> getRank(String queueId,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        QueueStatus status
                = queueService.getRank(queueId, customUserDetails.getIdx());

        return new BaseResponse<>(status);
    }

    /**
     * 대기열 필요 여부 확인
     *
     * @param programId
     * @return
     */
    @PostMapping("/allow")
    public BaseResponse<EnabledResponse> isEnable(@RequestParam Long programId) {
        Boolean queueNecessary = queueService.isQueueNecessary(programId);
        return new BaseResponse<>(EnabledResponse.builder()
                .isEnable(queueNecessary)
                .build());
    }

}
