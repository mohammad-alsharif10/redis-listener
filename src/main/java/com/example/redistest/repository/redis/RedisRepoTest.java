package com.example.redistest.repository.redis;

import com.example.redistest.entity.redis.RedisEntityTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepoTest {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisRepoTest(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void add(String key, RedisEntityTest value) {
        redisTemplate.opsForValue().set(key, value, 30, TimeUnit.SECONDS);
//        redisTemplate.expire(key, 20, TimeUnit.DAYS);
    }

    public void addNoExpire(String key, RedisEntityTest value) {
        redisTemplate.opsForValue().set(key, value);
//        redisTemplate.expire(key, 20, TimeUnit.DAYS);
    }

    public void delete(final String id) {
        redisTemplate.delete( id);
    }

    public RedisEntityTest find(final String id) {
        return (RedisEntityTest) redisTemplate.opsForValue().get(id);
    }
}
