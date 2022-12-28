package com.lima.battleofmyeongnyang.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseConfig {

  private String code = "HELLO-00000";
  private String msg = "SUCCESS";
  private Object response = "";

  public ResponseConfig getResponse(Object response) {
    // 다시보기
    return (ResponseConfig) (this.response = response);
  }
  public static ResponseConfig isHelloEmpty() {
    return new ResponseConfig();
  }
}
