package com.lima.battleofmyeongnyang.setting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {
  public static int counter;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 리스터 다음으로 2번째
    System.out.println("=================================================");
    log.info("Application started with option names : {}",args.getOptionNames());
    log.info("Increment counter");
    counter++;
  }
}