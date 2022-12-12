package com.lima.battleofmyeongnyang.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Configuration
public class ConsoleInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // TODO: 로직을 안탄다 살펴봐야할듯
    log.info("[ConsoleInterceptor.preHandle]");
    String authorization = request.getHeader("Authorization");
    System.out.println("authorization>>> "+ authorization);
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
