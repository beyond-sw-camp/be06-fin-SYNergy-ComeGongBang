package com.synergy.backend.domain.member.model.request;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.member.model.entity.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@RequiredArgsConstructor
public class MemberSignupReq {

    private String email;
    private String password;
    private String nickname;
    private String cellPhone;
    private LocalDate birthday;
    private String defaultAddress;

    @Builder
    public static Member toEntity(MemberSignupReq req,BCryptPasswordEncoder bCryptPasswordEncoder, Grade grade) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return Member.builder()
                .email(req.email)
                .password(bCryptPasswordEncoder.encode(req.getPassword()))
                .nickname(req.nickname)
                .cellPhone(req.cellPhone)
                .joinDate(localDateTime)
                .birthday(req.birthday)
                .grade(grade)
//                .defaultAddress(req.defaultAddress)
                .build();
    }

    public MemberSignupReq(String email, String nickname) {
        this.email = email;
        this.password="kakao";
        this.nickname = nickname;
    }
}
