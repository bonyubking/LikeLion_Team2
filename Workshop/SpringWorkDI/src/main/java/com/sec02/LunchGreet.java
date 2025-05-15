package com.sec02;

public class LunchGreet implements Greet {

  @Override
  public String greeting() {
    return "점심시간입니다";
  }

  // 생명주기 확인을 위한 메소드 추가
  public void init(){
    System.out.println("초기화");
  }

  public void doJob(){
    System.out.println("bean 수행중");
  }

  public void destory(){
    System.out.println("소멸");
  }
}
