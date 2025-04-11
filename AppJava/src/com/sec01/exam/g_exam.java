package com.sec01.exam;

public class g_exam {
	
	public static void prn01(int res) { 
		//메소드 호출할 때 정수값 받으면서 지역변수 생성해 값대입 함  
		System.out.println("정수 res ="+res);
	}
	
	public static void prn02(char res) { 
		//메소드 호출할 때 정수값 받으면서 지역변수 생성해 값대입 함  
		System.out.println("한문 res ="+res);
	}
	
	public static void prn03(double res,int a) { 
		//메소드 호출할 때 정수값 받으면서 지역변수 생성해 값대입 함  
		System.out.println("실 res ="+res+" 정수 a="+a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prn01(1);
		prn02('a');
		prn03(90.1,100);//실수 double과 int값을 전달하면서 호출
		prn03(100,100);
		prn03(100,'a');// 메소드 호출할 때 전달하는 값을 자동형변환 후 대입 및 실행
		//캐스팅 -> 변수에 값대입, 메소드에 값전달, 상속 객체 전달할때(자식의 객체를 주면 부모가 대입받음 = I/O클래스)
	}

}
