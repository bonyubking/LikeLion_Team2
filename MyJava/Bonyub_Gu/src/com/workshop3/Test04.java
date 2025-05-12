package com.workshop3;
//Math.random()을 이용해서 1부터 6사이의 임이의 int형 정수를 출력
// 하는 프로그램 작성  !! Math.random() 함수는 0이상 1미만의 실수 값 출력.
public class Test04 {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 6 + 1);
		System.out.println(a);

	}

}
