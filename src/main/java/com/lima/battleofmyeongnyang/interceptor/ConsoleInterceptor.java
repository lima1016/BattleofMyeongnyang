package com.lima.battleofmyeongnyang.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class ConsoleInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String authorization = request.getHeader("Authorization");
    // LIM: 권한 체크하기 유저 정보 Redis에 넣어놔야하는데 언제 넣지~? Interceptor 에서는 어떤 역할을 하는지 알아보기
    // Interceptor에서 체크 해야할 것
    // 1. 관리자 인지 일반 유저인지 근데 로그인할때 ID 판별해서 어드민 아이디인지 확인하려면 로그인할때는 interceptor 안타게 해야할듯
    request.getAuthType();
    System.out.println(request.getSession());
    for (Cookie cookie : request.getCookies()) {
        cookie.getDomain();
    }
    request.getSession().getId();
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
