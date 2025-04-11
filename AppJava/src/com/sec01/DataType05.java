package com.sec01;

//Wrapper class : Wrapper 클래스의 객체로 형변환 후 Object클래스가 가진 getClass().getSimpleName()
public class DataType05 {
	public static void main(String[] args) {
		float f = 3.141f;
		double d = 3.141d;
		double d2 = 3.141;
		System.out.println(f);
		System.out.println(d);
		System.out.println(d2);
		
		//데이터타입 확인
		System.out.println("float 타입 확인 :"+((Object)f).getClass().getSimpleName());
		System.out.println("double 타입 확인 :"+((Object)d).getClass().getSimpleName());
//		System.out.println("float 타입 확인 :"+((Object)d2).getClass().getSimpleName());
	}
}


