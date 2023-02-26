package com.lima.battleofmyeongnyang.Exception;

import lombok.Getter;

public enum BattleException {

  NO_PERMISSION("don't have permission");

  @Getter
  private String message;

  BattleException(String message) {
    this.message = message;
  }
}
