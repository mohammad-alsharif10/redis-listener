package com.example.redistest.controller;

import com.example.redistest.entity.redis.RedisEntityTest;
import com.example.redistest.repository.redis.RedisRepoTest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class Controller {

    private final RedisRepoTest redisRepoTest;

    @PatchMapping("/insert")
    public RedisEntityTest insert(@RequestBody RedisEntityTest redisEntityTest) {
        redisRepoTest.add(redisEntityTest.getId(), redisEntityTest);
        return redisRepoTest.find("ID");
    }

    @PatchMapping("/addNoExpire")
    public RedisEntityTest addNoExpire(@RequestBody RedisEntityTest redisEntityTest) {
        redisRepoTest.addNoExpire(redisEntityTest.getId(), redisEntityTest);
        return redisRepoTest.find("ID");
    }

    @GetMapping("/delete")
    public void delete(@RequestParam String key) {
        redisRepoTest.delete(key);
    }

    @GetMapping("/get/{key}")
    public RedisEntityTest get(@PathVariable String key) {
        return redisRepoTest.find(key);
    }
}
