package com.sec06;

import org.springframework.stereotype.Component;

@Component(value = "score")
public class Score {
	
	public void printScore() {
		System.out.println("Score component!!!");
	}
	
}
