package com.lima.battleofmyeongnyang.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseConfig {

  private String code = "HELLO-00000";
  private String msg = "SUCCESS";
  private String response = "";

  public static ResponseConfig isHelloEmpty() {
    return new ResponseConfig();
  }
}
