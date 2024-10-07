package com.synergy.backend.domain.grade.scheduler;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.service.FetchGradeService;
import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.grade.service.GradeCalculationService;
import com.synergy.backend.domain.grade.service.UpgradeService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GradeScheduler {

    private final FetchMemberService fetchMemberService;
    private final GradeCalculationService gradeCalculationService;
    private final UpgradeService upgradeService;
    private final FetchGradeService fetchGradeService;

    /* 최근 6개월 구매이력 확인
     * 등급 변화가 있는 사람만 등급 변경
     * 1. 등급이 올랐을 경우
     * 2. 등급이 하락한 경우
     */
    public GradeScheduler(@Qualifier("fetchAllMemberServiceImpl") FetchMemberService fetchMemberService,
                          GradeCalculationService gradeCalculationService,
                          UpgradeService upgradeService,
                          FetchGradeService fetchGradeService) {
        this.fetchMemberService = fetchMemberService;
        this.gradeCalculationService = gradeCalculationService;
        this.upgradeService = upgradeService;
        this.fetchGradeService = fetchGradeService;
    }

    @Async
//    @Scheduled(cron = "0 0 3 1 * ?")
    public void upgrade() throws BaseException {
        log.info("Starting grade upgrade process");

        // 회원 조회
        List<Member> allMember = fetchMemberService.FetchMember();
        log.info("Fetched {} members for grade upgrade.", allMember.size());

        //모든 등급 조회
        List<Grade> allGrades = fetchGradeService.getGrade();
        log.info("Fetched {}  grade.", allGrades.size());

        for (Member member : allMember) {
            Integer totalPrice = gradeCalculationService.gradeCalculation(member);
            log.info("회원 {}: 구매 금액 {}", member.getIdx(), totalPrice);

            Long curGradeIdx;
            if (member.getGrade() == null) {
                curGradeIdx = 1L;
            } else {
                curGradeIdx = member.getGrade().getIdx();
            }
            for (int i = 0; i < allGrades.size(); i++) {

                if (totalPrice >= allGrades.get(i).getConditionMin() &&
                        totalPrice < allGrades.get(i).getConditionMax()) {
                    Long expectedGradeIdx = allGrades.get(i).getIdx();

                    if (!curGradeIdx.equals(expectedGradeIdx)) {
                        log.info("회원 {}: 기존 등급 {} → 변경 등급 {}", member.getIdx(), curGradeIdx, expectedGradeIdx);
                        upgradeService.changeGrade(member, allGrades.get(i));
                    } else {
                        log.info("회원 {}: 등급 유지 {}", member.getIdx(), curGradeIdx);
                    }
                }
            }
        }
        log.info("end grade upgrade process");
    }
}