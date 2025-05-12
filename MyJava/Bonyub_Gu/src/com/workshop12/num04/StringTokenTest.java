package com.workshop12.num04;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {

		int ans = 0;
		
		String str = "4,2,3,6,7";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		
		while (st.hasMoreTokens()) {
			
			ans += Integer.parseInt(st.nextToken());
		}
		
		System.out.println(ans);
	}

}
