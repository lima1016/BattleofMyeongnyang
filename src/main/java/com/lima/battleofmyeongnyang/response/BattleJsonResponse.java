package com.lima.battleofmyeongnyang.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BattleJsonResponse {
  @JsonProperty("battle_code")
  private String code = "HELLO-00000";

  @JsonProperty("battle_msg")
  private String msg = "SUCCESS";

  @JsonProperty("battle_response")
  private Object response;

  public static BattleJsonResponse getResponseDetail(Object response) {
    response = response;
    return new BattleJsonResponse();
  }
}
