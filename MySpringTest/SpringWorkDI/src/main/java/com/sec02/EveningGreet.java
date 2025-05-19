package com.sec02;

public class EveningGreet implements Greet {
    public String greeting() {
        return "편안한 저녁입니다.";
    }
    
    public void init() {
    	System.out.println("쵸기화") ;
    }
    
    public void dojob() {
    	System.out.println("정상 수행중") ;
    }
    
    public void destroy() {
    	System.out.println("소멸") ;
    }
}