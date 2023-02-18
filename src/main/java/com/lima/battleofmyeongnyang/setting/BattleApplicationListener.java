package com.lima.battleofmyeongnyang.setting;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class BattleApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    System.out.println("=====================================");
    System.out.println("Lima Application Started...");
    System.out.println("=====================================");
  }
}
