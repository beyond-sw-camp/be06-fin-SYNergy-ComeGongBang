package com.synergy.backend.domain.coupon.model.type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

//쿠폰 발급 기간
@Embeddable
@Getter
public class IssueDate {

    @Column(name = "started_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startedAt;

    @Column(name = "finished_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime finishedAt;

    public void validate(LocalDateTime currentTime) throws BaseException {
        if (currentTime.isBefore(startedAt) || currentTime.isAfter(finishedAt)) {
            throw new BaseException(BaseResponseStatus.COUPON_ISSUANCE_PERIOD_NOT);
        }
    }
}
