package com.lima.battleofmyeongnyang.config.redistest;

import com.lima.battleofmyeongnyang.geoip.GeoEnum;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.EnumMap;

@SpringBootTest
public class RedisTest {

  // redis check
  @Resource
  StringRedisTemplate stringRedisTemplate;

  @Test
  void connectRedisTest() {
    final String key = "helloworld";
    final ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
    operations.set(key, "6"); // redis set 명령
    final String result1 = operations.get(key); // redis get 명령
    System.out.println("result1 = " + result1);

    operations.increment(key); // redis inor 명령어

    final String result2 = operations.get(key);
    System.out.println("result2 = " + result2);
  }
}
