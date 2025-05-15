package com.exam;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

//사용자 정의 스코프 생성
//사용자별로 고유한 bean 인스턴스를 유지하는 userScope를 만들기
public class UserScope implements Scope {
  private final ThreadLocal<Map<String, Object>> userScope = ThreadLocal.withInitial(HashMap::new);

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    // 사용자별 스코프 정보 리턴
    Map<String, Object> scope = userScope.get();
    return scope.computeIfAbsent(name,k-> objectFactory.getObject());
  }

  @Override
  public Object remove(String name) {
    // 삭제
    Map<String, Object> scope = userScope.get();
    return scope.remove(name);
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {

  }

  @Override
  public Object resolveContextualObject(String key) {
    return null;
  }

  @Override
  public String getConversationId() {
    return Thread.currentThread().getName();
  }
}
