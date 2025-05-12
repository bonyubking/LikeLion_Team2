package com.sec04;

import java.util.Scanner;

public class PatternSwitchExample {
    public static void main(String[] args) {
    	
    	Object obj = 41.2;
 /*   	Scanner sc = new Scanner(System.in);
    	Object obj = sc.next();
    	
  *       Object obj;
  *      
        if (sc.hasNextInt()) {
        	obj = sc.nextInt();
        } else if (sc.hasNextDouble()) {
        	obj = sc.nextDouble();
        } else {
        	obj = sc.next();}
  */     
        

        switch (obj) {
        	
        	case Integer i when (i > 10) -> System.out.println("10보다 큰 정수 " + i);
            case Integer i -> System.out.println("정수: " + i);
            case String s -> System.out.println("문자열: " + s);
            case null -> System.out.println("Null 값이 입력되었습니다.");
            case Double d -> System.out.println("실수: " + d);
            default -> System.out.println("알 수 없는 타입");
        }
    }
}

