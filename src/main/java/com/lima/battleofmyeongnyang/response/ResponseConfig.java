package com.lima.battleofmyeongnyang.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseConfig {

  private String code = "HELLO-00000";
  private String msg = "SUCCESS";
  private Object response;

  public ResponseConfig getResponse(Object response) {
    // response 형식
    return (ResponseConfig) (this.response = response);
  }

  // 응답쪽 수정해야함
  public static ResponseConfig isHelloEmpty() {
    System.out.println("이이ㅣ이이이이ㅣ");
    return new ResponseConfig();
  }
}
