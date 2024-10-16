package com.synergy.backend.domain.queue.controller;

import com.synergy.backend.domain.queue.model.response.EnabledResponse;
import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.domain.queue.service.QueueService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
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
     * @param couponIdx
     * @param customUserDetails
     * @return queueId와 대기열 진입 여부
     */
    @PostMapping
    public BaseResponse<RegisterQueueResponse> registerQueue(@RequestParam Long couponIdx,
                                                             @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {

        if (customUserDetails == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        RegisterQueueResponse registerQueueResponse
                = queueService.enterQueue(couponIdx, customUserDetails.getIdx());

        return new BaseResponse<>(registerQueueResponse);
    }

    /**
     * 대기열 현재 위치 확인
     *
     * @param queueIdx
     * @param customUserDetails
     * @return 대기열 현재 위치
     */
    @GetMapping("/rank")
    public BaseResponse<QueueStatus> getRank(@RequestParam String queueIdx,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        QueueStatus status
                = queueService.getRank(queueIdx, customUserDetails.getIdx());

        return new BaseResponse<>(status);
    }

    @DeleteMapping("/{queueIdx}")
    public BaseResponse<Void> deleteWaiting(@PathVariable String queueIdx,
                                            @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails.getIdx() == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        queueService.deleteWaiting(queueIdx, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.DELETE_QUEUE);
    }

    /**
     * 대기열 필요 여부 확인
     *
     * @param couponIdx
     * @return
     */
    @PostMapping("/allow")
    public BaseResponse<EnabledResponse> isEnable(@RequestParam Long couponIdx) {
        Boolean queueNecessary = queueService.isQueueNecessary(couponIdx);
        return new BaseResponse<>(EnabledResponse.builder()
                .isEnable(queueNecessary)
                .build());
    }

}
