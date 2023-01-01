package com.lima.battleofmyeongnyang.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseConfig {

  private String code = "HELLO-00000";
  private String msg = "SUCCESS";
  private Object response;

  public ResponseConfig getResponse(Object response) {
    // response 형식
    return (ResponseConfig) (this.response = response);
  }

  public Map getSuccessCode() {
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put(code, getCode());
    resultMap.put(msg, getMsg());
    System.out.println("어케 나오나");
    System.out.println(resultMap);
    return  resultMap;
  }
  public static ResponseConfig isHelloEmpty() {
    return new ResponseConfig();
  }
}
