package com.jiang.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author shijiang.luo
 * @description
 * @date 2020-09-17 22:33
 */
@Configuration
public class MyCacheConfig {

    @Bean
    public KeyGenerator keyGenerator(){

        return (Object target, Method method, Object...param) ->
             method.getName() + "[" + Arrays.asList(param).toString()+ "]";
    }

}