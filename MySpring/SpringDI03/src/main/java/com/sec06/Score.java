package com.sec06;

import org.springframework.stereotype.Component;

@Component(value = "score") // Score라는 Bean
public class Score {
  public void printScore(){
    System.out.println("Score component");
  }

}
