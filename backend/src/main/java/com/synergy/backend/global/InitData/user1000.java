package com.synergy.backend.global.InitData;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


// 회원 수 30만명 넣기


@Component
@RequiredArgsConstructor
public class user1000 {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private static final int USER_COUNT = 1000;

    //    @PostConstruct
    @Transactional
    public void init() {
        for (int id = 1; id <= USER_COUNT; id++) {
            createMember(id);
        }
    }

    private void createMember(int id) {
        String email = "user" + id + "@example.com";
        String password = "$2a$10$C0K9ensWWpxg/v63TNdv4ujQJMef1jww2FB4i5VXwt.gi5Q2wmqqq";
        String nickname = "User" + id;
        String cellPhone = "010-" + String.format("%04d", id % 10000) + "-" + String.format("%04d", id / 10000);
        LocalDateTime joinDate = LocalDateTime.now();

        // 랜덤 생일 생성
        Random random = new Random();
        int year = 1990 + random.nextInt(30); // 1990 ~ 2019
        int month = 1 + random.nextInt(12); // 1 ~ 12
        int day = 1 + random.nextInt(28); // 1 ~ 28 (각 달의 최대일을 고려)

        LocalDate birthday = LocalDate.of(year, month, day);

        Member member = Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .cellPhone(cellPhone)
                .joinDate(joinDate)
                .birthday(birthday)
                .build();
        memberRepository.save(member);
    }
}