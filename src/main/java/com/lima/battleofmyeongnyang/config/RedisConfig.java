package com.lima.battleofmyeongnyang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
// Spring Data Redis Repository를 이용하면 간단하게 Domain Entiry를 Redis Hash로 만들 수 있다.
// 트랜잭션을 지ㅜ언하지 않기 때문에 트랙잭션을 적용하고 싶다면 RedisTemplate을 사용해야한다.
//@Configuration
//public class RedisConfig {
//    @Value("${spring.data.redis.host}")
//    private String redisHost;
//    @Value("${spring.data.redis.port}")
//    private int redisPort;
//
//  @Bean
//  RedisConnectionFactory redisConnectionFactory() {
//    return new LettuceConnectionFactory(redisHost, redisPort);
//  }
//}
