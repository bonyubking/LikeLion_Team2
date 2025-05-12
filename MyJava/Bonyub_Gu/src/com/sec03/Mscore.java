package com.sec03;
/*
 * 	이름 , 세과목의 총점, 평균 구하는 클래스 만들자.
 * 			국어		수학		영어		총점		평균
 * 	홍길동	100		100		100						a1
 * 	정길동	90		90		90						b1
 * 	박길동	80		80		80						c1
 */
public class Mscore {

	public static void main(String[] args) {
		U_score[] score = new U_score[] {
				new U_score("홍길동", 100, 100, 100),
				new U_score("정길동", 90, 90, 90),
				new U_score("박길동", 80, 80, 80)
				};
		
		for (U_score res: score) {
			System.out.println(res);
			if (res.getName().trim().equals("박길동")) {
				res.setEng(100);
				res.setKor(100);
				res.setMat(100);
			System.out.println(res);
			}
		}
		
		
		}

}


