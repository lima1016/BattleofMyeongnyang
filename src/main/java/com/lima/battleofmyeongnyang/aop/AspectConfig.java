package com.lima.battleofmyeongnyang.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AspectConfig {
  @Around("com.lima.battleofmyeongnyang.aop.PointCuts.allController()")
  public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = 0;
    try {
      start = System.currentTimeMillis();
      log.info("[AOP] START");
      Object result = joinPoint.proceed(joinPoint.getArgs());
      return result;
    } finally {
      long stop = System.currentTimeMillis();
      String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
      String methodName = joinPoint.getSignature().getName();
      log.info("[{}.{}:{}]-{}", className, methodName, stop-start, joinPoint.getArgs());
    }
  }
}
