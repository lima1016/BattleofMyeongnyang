package com.lima.battleofmyeongnyang.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class BattleJsonResponse {
  @JsonProperty("battle_code")
  private String code;

  @JsonProperty("battle_msg")
  private String msg;

  @JsonProperty("battle_response")
  private Object response;

  public static BattleJsonResponse getResponse(Object response) {
    return BattleJsonResponse.builder()
        .code("BATTLE-00000")
        .msg("SUCCESS")
        .response(response)
        .build();
  }

}
