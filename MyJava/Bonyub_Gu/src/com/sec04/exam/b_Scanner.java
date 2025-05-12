package com.sec04.exam;
import java.util.Scanner;

/* 콘솔로 값을 입력 받는 방법 3가지
 * java.util.Scanner
 * java.io.BufferedReader
 * java.lang.System.in
 */

public class b_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String addr = sc.nextLine();
		String tel = sc.nextLine();
		System.out.printf("%10s, %10s, %10s \n", name, addr, tel);
		System.out.printf(name+addr+tel);
	}

}
