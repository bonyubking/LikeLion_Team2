package com.sec04;

public class WhileTest {
	
	public static void test01() {
		int i = 1;
		System.out.println("Countdown start!");
		while(i<=5) {
			System.out.printf("%5d", i);
			i++;
		}//while end
	}
	
	public static void test02() {
		int i = 1;
		while (i<=5) {
			i++;
			System.out.printf("%5d", i);
		}
	}
	
	/*
	 * 1~100까지 숫자를 출력.
	 * 조건 1 : 짝수만 출력 
	 * */
	public static void test03() {
		int i = 1; //초기값
		int cnt = 0; //개수 출력 변수 
		while (i<=100) {
			if(i % 2 == 0) {
				System.out.printf("%5d", i);
				cnt++;
			}
			i++; //숫자 증가
		}
		System.out.println(" end i ="+i+" cnt="+cnt);
	}
	
    public static void test04() {
    	int i = 1;
    	int cnt = 0;
    	while(i<=100) {
    		if(i%5 == 0) {
    			System.out.printf("%5c\n",'❤'️);
    			cnt++;
    		}else {
    			System.out.printf("%5d",i);
    			
    		}
    		i++;
    	}
    	System.out.println("cnt :"+cnt);
    }
	
	
	public static void main(String[] args) {
		test04();

//		int i = 1;
//		System.out.println("Countdown start!");
//
//		while (i <= 5) {
//			System.out.printf("%5d", i);
//			i++;
//		}// while end
	}// main end
}// WhileTest end

