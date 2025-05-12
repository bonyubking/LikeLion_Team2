package com.workshop3;

public class Test01 {

	public static void main(String[] args) {
		int i = 1;
		int ans = 0;
		while (i<=20) {
			if ((i%2 != 0) && (i%3 != 0)) {
				ans += i;
				}
			i++;
		}
		
		System.out.println("sum = " + ans);

	}

}
