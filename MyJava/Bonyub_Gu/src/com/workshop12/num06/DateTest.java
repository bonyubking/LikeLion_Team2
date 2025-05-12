package com.workshop12.num06;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) { 
        // 2025년 8월 30일 토요일 21시 48분 10초 설정 
        Calendar cal = Calendar.getInstance(); 
        cal.set(2025, Calendar.AUGUST, 30, 21, 48, 10);   

        Date date = cal.getTime(); 
 
        ConvertDate converter = new ConvertDate(); 
 
        System.out.println("1) " + ConvertDate.convert(date, 1)); 
        System.out.println("2) " + ConvertDate.convert(date, 2)); 
        System.out.println("3) " + ConvertDate.convert(date, 3)); 
    } 

}
