package com.lima.battleofmyeongnyang.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

  @Pointcut("execution(* *..*Controller.*(..))")
  public void allController(){}

}
