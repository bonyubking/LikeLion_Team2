package com.workshop12.num01;

import java.util.Scanner;

public class CalcTest {
	public static void main(String[] args) {
	Scanner Sc = new Scanner(System.in);
	
	int num1 = Sc.nextInt();
	String oper = Sc.next();
	int num2 = Sc.nextInt();
	
	
	switch (oper) {
	    case "+":
	        System.out.println("결과: " + Calculator.plus(num1,num2));
	        break;
	    case "-":
	        System.out.println("결과: " + Calculator.minus(num1,num2));
	        break;
	    case "*":
	        System.out.println("결과: " + Calculator.multiplication(num1,num2));
	        break;
        case "/":
        	try {
    	        System.out.println("결과: " + Calculator.divide(num1,num2));
        	}
        	catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
        	}
        	break;
		
	}
	
	Sc.close();
 }
}
