package com.sec07.mytest;

import com.sec07.exam.AA;
import com.sec07.exam.BB;
import com.sec07.exam.DD;

public class MTest01 {

	public static void main(String[] args) {
		DD d1 = new DD();
		System.out.println("초기 확인 : " + d1.getRes());
	}
	
	
	public static void prn02(AA res) {
		
		res.setA(100);
		res.setB(20);
		((BB) res).setC(1);
		((DD) res).setD(1);
		System.out.println(((DD) res).getRes()); // 동적 바인딩 : 생성된 객체 주소를 객체가 참조해서 후손을 필요해서 따라가는것
		}
}
