package com.sec06;

import org.springframework.stereotype.Component;

@Component  // 나 score라는 bean이야
public class Score {	
	public void printScore() {
		System.out.println("Score component");
	}
}
