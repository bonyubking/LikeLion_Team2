package com.test04;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {
    public void eat(String food) {
        System.out.println("[Student] " + food + " 먹는 중...");
    }
}