package com.sec04.exam;

public class WhileTest {


		
		public static void test01() {
			int i = 1;
			System.out.println("Countdown Start!");
			while (i<=5) {
				System.out.printf("%5d", i);
				i++;
			}
		}
		
		private static void test02() {
			int i = 1;
			while (i<=5) {
				i++;
				System.out.printf("%5d", i);
			}
			
		}
		
		/* 1~100 까지 숫자를 출력 (while 문)
		 * 조건 1: 짝수만 출력하자
		 * 
		 */
		public static void test03() {
			int i = 1;
			int cnt = 0;
			while (i <= 100) {
				if (i % 2 == 0) {
					System.out.printf("%5d", i);
					cnt++;
				}
				i++;

			}
			System.out.println("end i =  " + i);
			System.out.println("짝수의 갯수 = " + cnt);
					
		}
		/* 1. 5의 배수에 하트를 주자
		 * 
		 * 
		 */
		public static void test04() {
			int i = 1;
			int cnt = 0;
			while (i <= 100) {
				if (i % 5 == 0) {
					System.out.printf("%5c\n", '*');
					cnt++;
				}
				else {
					System.out.printf("%5d", i);
				}
				i++;

			}
			System.out.println("cnt :" + cnt );
					
		}
		
		public static void main(String[] args) {
			//test01();
			System.out.println("\n---------\n");
			//test02();
			test04();
	}

}
