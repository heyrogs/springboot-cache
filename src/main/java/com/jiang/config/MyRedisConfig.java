package com.jiang.config;

import com.jiang.entity.vo.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.net.UnknownHostException;

/**
 * @author shijiang.luo
 * @description
 * @date 2020-09-18 23:01
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, UserVO> userRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, UserVO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        RedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(UserVO.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }

}