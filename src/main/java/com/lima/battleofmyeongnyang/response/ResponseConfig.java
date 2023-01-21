package com.lima.battleofmyeongnyang.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;

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

  public Map<String, Object> getResponse(Object response) {
    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("code", this.code);
    responseMap.put("msg", this.msg);
    responseMap.put("response", response);
    this.response = response;
    return responseMap;
  }

  // 응답쪽 수정해야함
  public static JSONObject isHelloEmpty() {
    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("code", "HELLO-00000");
    responseMap.put("msg", "SUCCESS");
    return new JSONObject(responseMap);
  }
}
