package com.workshop12.num06;

import java.util.Date;

import java.text.SimpleDateFormat;

public class ConvertDate {
	
	public static String convert(Date date, int type) {
		
		SimpleDateFormat ex;
		String formattedDate = "";
		
		switch (type) {
			case 1:
				ex = new SimpleDateFormat("yyyy-MM-dd");
				formattedDate = ex.format(date);
				break;
			case 2:
				ex = new SimpleDateFormat("yy년 MM월 dd일 EEEE");
				formattedDate = ex.format(date);
				break;	
			case 3:
				ex = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
				formattedDate = ex.format(date);
				break;	
				
		}
			
			
		return formattedDate;
	}

}
