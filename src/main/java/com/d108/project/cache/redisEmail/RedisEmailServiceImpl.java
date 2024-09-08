package com.d108.project.cache.redisEmail;

import com.d108.project.cache.redis.RedisUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

// 별도로 entity 를 설정할 정도로 복잡한 로직은 아닌 것 같음.
@Service
@RequiredArgsConstructor
public class RedisEmailServiceImpl implements RedisEmailService {

    @Value("${spring.mail.username}")
    private String hostEmail;

    private final RedisUtil redisUtil;
    private final JavaMailSender mailSender;
    private static final SecureRandom random = new SecureRandom();

    // 임의의 6자리 숫자 이메일 인증 코드 생성
    // 이건 private 로 설정하고, 이메일 전송과 검증만 public 으로 하면 될 듯
    private String createAuthCode(String email) {
        String authCode = String.format("%06d", random.nextInt(900000) + 100000);
        redisUtil.setDataExpire(email, authCode, 60*5);
        return authCode;
    }

    // 이메일과 인증코드를 검증
    @Override
    public Boolean checkAuthCode(String email, String authCode) {
        // email의 키값으로 저장된 코드와 입력한 인증코드와 같은지 다른지 검증
        if (authCode.equals(redisUtil.getData(email))) {
            // 코드가 일치하면 레디스에서 즉시 삭제
            redisUtil.deleteData(email);
            return true;
        }
        return false;
    }

    @Override
    public void sendEmail(String email) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
        String authCode = createAuthCode(email);
        // TODO: 메일 템플릿 정하기
        String title = "제목";
        String content = "인증번호는" + authCode + "입니다";

        messageHelper.setFrom(hostEmail);
        messageHelper.setTo(email);
        messageHelper.setSubject(title);
        messageHelper.setText(content, true);
        mailSender.send(message);
    }
}
