package com.d108.project.cache.redisEmail;

public interface RedisEmailService {
    // 인증코드 검증
    Boolean checkAuthCode(String email, String authCode);
    // 인증 메일 발송
    void sendEmail(String email);
}
