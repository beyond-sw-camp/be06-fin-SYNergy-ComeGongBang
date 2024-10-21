package com.synergy.backend.domain.member.service;

import com.synergy.backend.domain.member.model.request.MemberEmailAuthReq;
import com.synergy.backend.domain.member.repository.MemberEmailAuthRepository;
import java.time.Duration;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberEmailAuthService {

    private final JavaMailSender emailSender;

    private final MemberEmailAuthRepository memberEmailAuthRepository;

    private final RedisTemplate<String, String> redisTemplate;

    // 이메일 요청
    public String sendEmail(MemberEmailAuthReq req) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(req.getEmail());
        message.setSubject("[Come'공방 사이트] 인증 메일 요청");

        String uuid = UUID.randomUUID().toString().substring(0, 6).toUpperCase();


        message.setText("가입을 완료하시려면 회원가입 창으로 돌아간 후 아래 코드를 입력해주세요.\n" + uuid);

        emailSender.send(message);

        return uuid;
    }

    public String saveEmailAuthInfo(MemberEmailAuthReq req, String uuid) {
//        Optional<MemberEmailAuth> findEmail = memberEmailAuthRepository.findByEmail(req.getEmail());
//        redisTemplate.hasKey("emailAuth:"+uuid);
//        if(findEmail.isPresent()){
//            findEmail.get().changeUuid(uuid);
//            System.out.println("기존에 email이 있어서 uuid 변경");
//            memberEmailAuthRepository.save(findEmail.get());
//            return "저장 성공";
//        }
//        MemberEmailAuth emailAuth = MemberEmailAuth.builder()
//                .email(req.getEmail())
//                .uuid(uuid)
//                .build();

//        MemberEmailAuth result = memberEmailAuthRepository.save(emailAuth);
        redisTemplate.opsForValue().set("emailAuth:" + uuid, req.getEmail(), Duration.ofHours(1));
//        if(result == null){
//            return "유효하지 않은 이메일 정보";
//        }
        return "저장 성공";
    }


    public boolean verifyUuid(MemberEmailAuthReq req) {
//        Optional<MemberEmailAuth> result = memberEmailAuthRepository.findByEmailAndUuid(req.getEmail(),
//                req.getUuid());

        Boolean hasUuid = redisTemplate.hasKey("emailAuth:" + req.getUuid());

        if (hasUuid) {
            if (redisTemplate.opsForValue().get("emailAuth:" + req.getUuid()).equals(req.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
