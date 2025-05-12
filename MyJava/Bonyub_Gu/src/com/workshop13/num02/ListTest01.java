package com.workshop13.num02;

import java.util.Scanner;

public class ListTest01 {

	public static void main(String[] args) {
		
		Scanner num = new Scanner(System.in);
		int key = num.nextInt();
		
		MakeList lst = new MakeList();
		
		lst.makeArrayList(key);
		
		System.out.println(lst.getList());
		
		System.out.println("평균 :" + lst.getAverage());
	}

}
