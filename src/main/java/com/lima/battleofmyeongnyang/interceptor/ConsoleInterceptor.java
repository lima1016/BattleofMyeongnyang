package com.lima.battleofmyeongnyang.interceptor;

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
    log.info("ConsoleInterceptor.preHandle().handler : " + handler);
    log.info("ConsoleInterceptor.preHandle().request : " + request.getMethod());
    log.info("ConsoleInterceptor.preHandle().response : " + response.getStatus());

    // login user ip 정보 저장
    // 유저 정보 확인한 다음에 정보 저장...
//    if (Objects.nonNull(request.getRemoteAddr())) {
//      LoginMember.getInstance().setLoginIp(new Inet(request.getRemoteAddr()));
//    }

    // LIM: 권한 체크하기 유저 정보 Redis에 넣어놔야하는데 언제 넣지~? Interceptor 에서는 어떤 역할을 하는지 알아보기
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
