package com.synergy.backend.domain.coupon.model.type;

import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

//쿠폰 발급 기간
public class IssueDate {

    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    public void validate(LocalDateTime currentTime) throws BaseException {
        if (currentTime.isBefore(startedAt) || currentTime.isAfter(finishedAt)) {
            throw new BaseException(BaseResponseStatus.COUPON_ISSUANCE_PERIOD_NOT);
        }
    }
}
