package edu.hlju.boler.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    @Resource(name = "jedisConnectionFactory")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);
        return redisTemplate;
    }

}
