package com.lima.battleofmyeongnyang.domains.member;

import io.hypersistence.utils.hibernate.type.basic.Inet;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;

@Data
public class LoginMember {

  private String loginId;
  private Inet loginIp;
  private RedisTemplate redisTemplate;

  private static class Singleton {
    private static final LoginMember INSTANCE = new LoginMember();
  }

  public static LoginMember getInstance() {
    return Singleton.INSTANCE;
  }

  public void setRedisTemplate(String loginId, Inet loginIp) {
    this.loginId = loginId;
    this.loginIp = loginIp;
  }
}
