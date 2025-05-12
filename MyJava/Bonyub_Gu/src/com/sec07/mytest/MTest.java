package com.sec07.mytest;

import com.sec07.exam.AA;
import com.sec07.exam.BB;
import com.sec07.exam.DD;

public class MTest {

	public static void main(String[] args) {
		
		AA a1 = new DD(); // AA(), BB(), DD()
		BB b1 = new DD(); // AA() , BB(), DD()
		BB b2 = new BB(); /// AA(), BB()
		AA c1 = new BB(); // AA() , BB()
		
		check_instance(c1);

		}
	
	public static void check_instance(AA obj) {
		if (obj instanceof DD) {
			System.out.println("객체는 DD 클래스의 인스턴스 이다. ");
		}else if(obj instanceof BB) {
			System.out.println("객체는 BB 클래스의 인스턴스 이다. ");
		}else {
			System.out.println("객체는 AA 클래스의 인스턴스 이다. ");
		}
		
	}

}

