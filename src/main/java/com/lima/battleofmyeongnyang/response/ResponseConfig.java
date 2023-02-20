package com.lima.battleofmyeongnyang.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ResponseConfig {

  @JsonProperty("battle_code")
  private String code = "BATTLE-00000";

  @JsonProperty("battle_msg")
  private String msg = "SUCCESS";

  // 응답쪽 수정해야함
  public static ResponseConfig isHelloEmpty() {
    return new ResponseConfig();
  }
}
