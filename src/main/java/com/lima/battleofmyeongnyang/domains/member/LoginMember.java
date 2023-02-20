package com.lima.battleofmyeongnyang.domains.member;

import io.hypersistence.utils.hibernate.type.basic.Inet;
import lombok.Data;

@Data
public class LoginMember {

  private String loginId;
  private Inet loginIp;

  private static class Singleton {
    private static final LoginMember INSTANCE = new LoginMember();
  }

  public static LoginMember getInstance() {
    return Singleton.INSTANCE;
  }
}
