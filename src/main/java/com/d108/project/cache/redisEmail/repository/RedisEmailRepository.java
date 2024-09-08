package com.d108.project.cache.redisEmail.repository;

import com.d108.project.cache.redisEmail.entity.RedisEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedisEmailRepository extends JpaRepository<RedisEmail, String> {
}
