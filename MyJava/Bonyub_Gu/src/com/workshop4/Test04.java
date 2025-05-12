package com.workshop4;

public class Test04 {

	public static void main(String[] args) {
		
		Calc arr = new Calc();
		
		arr.setA(Integer.parseInt(args[0]));
		arr.setB(Integer.parseInt(args[1]));
		arr.setC(Integer.parseInt(args[2]));
		arr.setD(Integer.parseInt(args[3]));
		
		float Avg = (float)arr.calcSum()/(float)args.length;
		char score = 0;
		
		System.out.println("Sum:"+arr.calcSum());
		System.out.println("Avg:"+Avg);
		
		if (Avg <= 100) {
			score = 'A';
		}
		else if (Avg >= 70) {
			score = 'B';
		}
		else if (Avg >= 50) {
			score = 'C';
		}
		else if (Avg >= 30) {
			score = 'D';
		}
		else {
			score ='F';
		}
		
		System.out.printf("%C"+"학점",score);
		
		
	}

}
