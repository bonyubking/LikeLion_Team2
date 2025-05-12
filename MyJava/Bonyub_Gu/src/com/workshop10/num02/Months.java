package com.workshop10.num02;

import java.util.HashMap;
import java.util.Map;

public class Months {
	
	
    private static final Map<Integer, Integer> monthDays = new HashMap<>();
    
    static {
        monthDays.put(1, 31);  // January
        monthDays.put(2, 28);  // February (일반년 기준)
        monthDays.put(3, 31);  // March
        monthDays.put(4, 30);  // April
        monthDays.put(5, 31);  // May
        monthDays.put(6, 30);  // June
        monthDays.put(7, 31);  // July
        monthDays.put(8, 31);  // August
        monthDays.put(9, 30);  // September
        monthDays.put(10, 31); // October
        monthDays.put(11, 30); // November
        monthDays.put(12, 31); // December
    }
    
    
	public int getDays(int months) {
		
		return monthDays.getOrDefault(months, 0);
		
	}
}
