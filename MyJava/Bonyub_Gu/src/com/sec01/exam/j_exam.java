package com.sec01.exam;

public class j_exam {
	public static void main(String[] args) {
		
		int a,b,hap,sub,mul;
		double div;
		
		a=100;
		b=200;
		hap = sub = mul = 0;
		div = 0.0;
		
		hap = Calc.getHap(a,b);
		sub = Calc.getSub(a,b);
		mul = Calc.getMul(a,b);
		div = Calc.getDiv(a,b);
		
		System.out.println(a+"+"+b+"="+hap);
		System.out.println(b+"-"+a+"="+sub);
		System.out.println(a+"*"+b+"="+mul);
		System.out.println(b+"/"+a+"="+div);
	}

}
