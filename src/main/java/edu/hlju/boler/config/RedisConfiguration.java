package edu.hlju.boler.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置类，通过JavaConfig实现注入
 * @author jingqingyun
 */
@Configuration
public class RedisConfiguration {

    /**
     * 注册RedisTemplate Bean
     * @param rcf 在root-context.xml文件里配置的RedisConnectionFactory Bean
     * @return 通过@Bean注解注册到容器中
     */
    @Bean // 通过@Bean注解将方法返回的对象注册到Bean容器中
    @Resource(name = "jedisConnectionFactory")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);
        // 设置key序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value序列化器，使用Jackon2
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        return redisTemplate;
    }

}
