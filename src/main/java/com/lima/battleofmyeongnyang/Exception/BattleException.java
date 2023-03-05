package com.lima.battleofmyeongnyang.Exception;

import lombok.Getter;

public enum BattleException {

  NO_PERMISSION("don't have permission"),
  DONT_HAVE_AN_ACCOUNT("don't have an account");

  @Getter
  private String message;

  BattleException(String message) {
    this.message = message;
  }
}
