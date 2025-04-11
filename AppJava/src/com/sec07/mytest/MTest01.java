package com.sec07.mytest;

public class MTest01 {

	public static void main(String[] args) {
		
		//객체를 초기값으로 생성해 놓고 setter로 값을 전달 및 변경 후 결과를 리턴
		DD d1 = new DD(1,2,3,4);
		System.out.println("초기값 확인 : "+d1.getRes());
		BB b1 = new DD(1,2,3,4);
		prn(b1);
		
		prn02(b1);
		
		//객체를 생성할 때 초기값 전달 후 연산 결과 리턴
		
		

	}
	
	public static void prn(DD res) {
		res.setA(100);
		res.setA(20);
		res.setA(1);
		res.setA(1);
		System.out.println(res.getRes());
	}
	public static void prn02(AA res) {
		//동적 바인딩 : 생성된 객체 주소를 선조의 객체가 참조해서 후손을 필요에 따라 찾아 가는 것
		res.setA(100);
		res.setA(20);
		((BB)res).setA(1);
		((DD)res).setA(1);
		System.out.println(((DD)res).getRes());
	}

}
