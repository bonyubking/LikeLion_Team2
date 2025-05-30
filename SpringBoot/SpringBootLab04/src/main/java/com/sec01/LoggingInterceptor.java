package com.sec01;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// HandlerInterceptor -> MVC 요청, 시작, 종료의 흐름을 가로채기해서 로그
@Component
public class LoggingInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler)
      throws Exception{
    System.out.println(">> 요청 URL:"+request.getRequestURI());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    throws Exception {
    System.out.println("<<요청완료");
  }



}
