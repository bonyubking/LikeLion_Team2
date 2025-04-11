package com.sec02.exam;

public class b_exam {
	
	//Instance Methods
	public void prn() {
		System.out.println("non-static");
	}

	public static void main(String[] args) {
		b_exam m = new b_exam(); 
		System.out.println(m.toString());
		
		b_exam m2 = new b_exam(); 
		System.out.println(m2.toString());

	}

}
