package com.d108.project.cache.redisEmail.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "emails", timeToLive = 60*5) // 60sec * 5min
@Getter
public class RedisEmail {
    @Id
    private String email;
    // 인증 코드
    private String authCode;
}
