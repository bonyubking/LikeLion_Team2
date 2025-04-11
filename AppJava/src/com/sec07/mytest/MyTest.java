package com.sec07.mytest;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyTest extends GregorianCalendar{
	
	public MyTest(int i,int j,int k) {
		super(i,j,k); 
		//여기선 GregorianCalendar(int year, int month, int dayOfMonth)가 호출됨 
	}
	
	@Override
	public String toString() {
		return "내꺼!!!";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTest m1 = new MyTest(2025,3,11);
		System.out.println(m1.toString());
		System.out.println(m1.get(Calendar.YEAR)+":"+m1.get(Calendar.MONTH)+":"+m1.get(Calendar.DAY_OF_MONTH));
		m1.set(Calendar.YEAR, 2000);
		m1.set(Calendar.MONTH, 11);
		System.out.println(m1.get(Calendar.YEAR)+":"+m1.get(Calendar.MONTH)+":"+m1.get(Calendar.DAY_OF_MONTH));

	}

}
