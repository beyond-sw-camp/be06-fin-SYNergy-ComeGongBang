package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GradeCalculationService {

    private final OrderRepository orderRepository;

    public Integer gradeCalculation(Member member) {
        LocalDate now = LocalDate.now();
        LocalDateTime startDateTime = now.minusMonths(6).withDayOfMonth(1).atStartOfDay();
        java.time.LocalDateTime endDateTime = now.withDayOfMonth(now.lengthOfMonth()).atTime(23, 59, 59);
        Integer totalPrice = orderRepository.findTotalAmountByMemberIdAndDateRange(member.getIdx(), startDateTime, endDateTime);
        if (totalPrice == null) {
            totalPrice = 0;
        }
        return totalPrice;
    }
}
