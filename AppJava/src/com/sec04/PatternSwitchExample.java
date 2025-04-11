package com.sec04;

public class PatternSwitchExample {
    public static void main(String[] args) {
        // 1) break를 화살표레이블(->)로 대체
    	
    	
    	Object obj = 42;
        switch (obj) {
            case Integer i when i > 10 -> System.out.println("10보다 큰 정수: " + i);
            case Integer i -> System.out.println("정수: " + i);
            case String s -> System.out.println("문자열: " + s);
            case null -> System.out.println("Null 값이 입력되었습니다.");
            default -> System.out.println("기타 값: " + obj);
        }
    }
}