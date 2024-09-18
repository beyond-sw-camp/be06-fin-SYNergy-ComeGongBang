package com.synergy.backend.domain.grade.scheduler;

import com.synergy.backend.domain.grade.service.FetchMemberService;
import com.synergy.backend.domain.grade.service.GradeCalculationSerivce;
import com.synergy.backend.domain.grade.service.UpgradeService;
import com.synergy.backend.domain.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GradeScheduler {

    private final FetchMemberService fetchMemberService;
    private final GradeCalculationSerivce gradeCalculationSerivce;
    private final UpgradeService upgradeService;

    //업그레이드
    @Scheduled(cron = "0 0 0 1 * ?")
    public void upgrade() {
        //최근 한 달 구매이력이 있는 사람만 조회
        List<Member> allMember = fetchMemberService.FetchMember();

        for (Member member : allMember) {
            //최근 6개월 구매이력 확인 -> 등급 변화가 있는 사람만 등급 업
            Boolean isUpgrade = gradeCalculationSerivce.gradeCalculation(member);

            // 등급 변화가 있으면
            if (isUpgrade) {
                upgradeService.upgrade(member);
            }
        }
    }
}
