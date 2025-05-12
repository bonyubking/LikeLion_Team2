package com.sec07.mytest;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyTest extends GregorianCalendar{
	
	public MyTest(int year, int month, int dayofMonth) {
		super(year,month,dayofMonth);
	}
	
	@Override
	public String toString() {
		return "내꺼 " ;
		
	}
	public static void main(String[] args) {
		MyTest m1 = new MyTest(2025, 3, 11);
		System.out.println(m1.toString());
		System.out.println(m1.get(Calendar.YEAR) + ":" + m1.get(Calendar.MONTH) + ":" + m1.get(Calendar.DAY_OF_MONTH));
	}

}
