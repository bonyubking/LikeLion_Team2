package com.workshop6;

public class Test03 {

	public static void main(String[] args) {

		int num = Integer.parseInt(args[0]);
		int ans = 0;
		int key = 0;
		
		for (int i=num; i<=10; i++) {
			
			if (i%3!=0 && i%5!=0 && key==1) {
				System.out.printf("+ ");
			}
			if (i%3!=0 && i%5!=0) {
				ans += i;
				key = 1;
				System.out.printf("%d ", i);
			}
		}
		
		System.out.println();
		System.out.printf("결과 : %d", ans);
	}

}
