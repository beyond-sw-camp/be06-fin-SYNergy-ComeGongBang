package com.synergy.backend.domain.grade.service;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.model.response.GetMyGradeRes;
import com.synergy.backend.domain.grade.model.response.GradeRes;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    public List<GradeRes> getAllGrade() {
        return gradeRepository.findAll().stream().map(grade ->
                GradeRes.from(grade)
        ).collect(Collectors.toList());
    }

    public GetMyGradeRes getMyGrade(Long idx) throws BaseException {
        Member member = memberRepository.findById(idx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));

        LocalDate now = LocalDate.now();

        LocalDateTime startDateTime = now.minusMonths(6).withDayOfMonth(1).atStartOfDay();
        LocalDateTime endDateTime = now.withDayOfMonth(now.lengthOfMonth()).atTime(23, 59, 59);
        Integer totalAmount = orderRepository.findTotalAmountByMemberIdAndDateRange(idx, startDateTime, endDateTime);

        Grade curGrade = member.getGrade();
        String curGradeName = curGrade.getName();
        Long curGradeIdx = curGrade.getIdx();

        // 전체 등급 조회
        List<GradeRes> allGrades = getAllGrade();
        String expectedGrade = null;
        String expectedGradeBenefit = null;
        String benefitsMessage = null;
        String amountToNext = null;

        if (totalAmount == null) {
            totalAmount = 0;
        }

        for (int i = 0; i < allGrades.size(); i++) {
            GradeRes grade = allGrades.get(i);
            if (totalAmount >= grade.getConditionMin() &&
                    totalAmount < grade.getConditionMax()) {

                expectedGrade = grade.getName();
                Long expectedGradeIdx = grade.getGradeIdx();

                if (curGradeIdx.equals(expectedGradeIdx)) {

                    // 현재 등급과 예상 등급이 같은 경우
                    if (i + 1 < allGrades.size()) {

                        // 다음 등급이 존재하는 경우
                        amountToNext = formatCurrency(Math.max(0, allGrades.get(i + 1).getConditionMin() - totalAmount));
                        benefitsMessage = amountToNext + "원만 더 구매하면 다음 달 " + allGrades.get(i + 1).getName() + " 혜택을 받을 수 있습니다.";
                        expectedGradeBenefit = allGrades.get(i + 1).getName() + "등급 혜택: 추가할인 " + allGrades.get(i + 1).getDefaultPercent() + "% + " + "정기쿠폰";
                    } else {

                        // 마지막 등급인 경우
                        amountToNext = "0원";
                        benefitsMessage = "현재 등급은 " + expectedGrade + "입니다! ";
                    }
                } else if (curGradeIdx < expectedGradeIdx) {

                    // 예상 등급이 현재 등급보다 높은 경우
                    amountToNext = formatCurrency(Math.max(0, grade.getConditionMin() - totalAmount));
                    benefitsMessage = "다음 달 " + expectedGrade + " 혜택을 받을 수 있습니다.";
                    expectedGradeBenefit = expectedGrade + "등급 혜택: 추가할인 " + allGrades.get(i + 1).getDefaultPercent() + "% + " + "정기쿠폰";

                } else {

                    // 예상 등급이 현재 등급보다 낮은 경우
                    amountToNext = "승급 불가능";
                    benefitsMessage = "다음 달 예상 등급은 " + expectedGrade + "입니다.";
                    expectedGradeBenefit = expectedGrade + "등급 혜택: 추가할인 " + allGrades.get(i + 1).getDefaultPercent() + "% + " + "정기쿠폰";

                }

                break;
            }
        }

        // 예상 등급이 없으면 현재 등급을 예상 등급으로
        if (expectedGrade == null) {
            expectedGrade = curGradeName;
            amountToNext = "0원";
            benefitsMessage = "현재 등급은 " + curGradeName + "입니다.";
        }

        return GetMyGradeRes.from(curGradeName, expectedGrade,expectedGradeBenefit, amountToNext, allGrades, benefitsMessage);
    }


    public String formatCurrency(Integer amount) {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("ko", "KR"));
        return formatter.format(amount);
    }
}

