package com.synergy.backend.member.model.request;

import com.synergy.backend.member.model.entity.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@RequiredArgsConstructor
public class MemberSignupReq {

    private String email;
    private String password;
    private String name;
    private String cellPhone;
    private LocalDate birthday;
    private String gender;
    private String defaultAddress;

    @Builder
    public static Member toEntity(MemberSignupReq req,BCryptPasswordEncoder bCryptPasswordEncoder) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return Member.builder()
                .email(req.email)
                .password(bCryptPasswordEncoder.encode(req.getPassword()))
                .nickname(req.name)
                .cellPhone(req.cellPhone)
                .joinDate(localDateTime)
                .birthday(req.birthday)
                .gender(req.gender)
//                .defaultAddress(req.defaultAddress)
                .build();
    }
}
