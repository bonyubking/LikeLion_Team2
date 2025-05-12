package com.workshop13.num07;

import java.util.HashMap;
import java.util.Map;

public class MapTest { 
 
    public static void main(String[] args) { 
    
    Map<String, Mobile> map = new HashMap<String, Mobile>(); 
    double sum = 0.0; 
    
    Mobile m1 = new Mobile("LU6800","Optimus 2X",800000);
    Mobile m2 = new Mobile("SU6600","Optimus Black",900000);
    Mobile m3 = new Mobile("KU5700","Optimus Big",700000);
    Mobile m4 = new Mobile("SU7600","Optimus Mach",950000);
    
    // map에 4개의 객체를 code를 키 값으로 넣는다.
    map.put(m1.getCode(), m1);
    map.put(m2.getCode(), m2);
    map.put(m3.getCode(), m3);
    map.put(m4.getCode(), m4);
    
    // Mobile 정보를 출력 하고 합계를 계산 
	for(String code : map.keySet()) { 
		
		Mobile mobile = map.get(code);
		System.out.println(mobile.printInfo());
	    sum += mobile.getPrice();
		
	} 
	
	System.out.println("합계: " + sum);
	System.out.println();
	sum = 0.0;
     // Mobile 객체의 가격 정보를 10% 증가 시킨다. 

	for (String code : map.keySet()) {
	    Mobile mobile = map.get(code);
	    double oldPrice = mobile.getPrice();
	    mobile.setPrice(oldPrice * 1.1);
	}
     // 변경된 정보를 출력 하고 합계를 계산  
	for(String code : map.keySet()) { 
		
		Mobile mobile = map.get(code);
		System.out.println(mobile.printInfo());
	    sum += mobile.getPrice();
	}
	System.out.println("합계: " + String.format("%.1f", sum));
    } 
} 
