package com.jiang;

import com.jiang.entity.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Slf4j
@SpringBootTest
class SprinbootCacheApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; // k-v 都是字符串

    @Autowired
    RedisTemplate redisTemplate;  // k-v 都是对象


    @Autowired
    RedisTemplate userRedisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void redisTemplateTest(){
        stringRedisTemplate.opsForValue().append("name", "hello redis");
        String value = stringRedisTemplate.opsForValue().get("name");
        log.info("name: {}", value);
    }

    @Test
    public void userRedisTemplateTest(){
        UserVO userVO = new UserVO(1, "test", 20);
        userRedisTemplate.opsForValue().set("userVO", userVO);
        userVO = (UserVO) userRedisTemplate.opsForValue().get("userVO");
        log.info("userVO: {}", userVO);
    }

}
