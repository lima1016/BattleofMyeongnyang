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

  // LIM: 으아아아아 Json 형식이였으면좋겠어~!!
  public Map getSuccessCode() {
    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put(code, getCode());
    resultMap.put(msg, getMsg());
    return  resultMap;
  }
  public static ResponseConfig isHelloEmpty() {
    return new ResponseConfig();
  }
}
