package com.sec06;


public class TvTest02{
	public static void main(String[] args) {

		//Case3. 동적 메모리 확보 후 값  대입
		Tv[] tvs = new Tv[3];
		tvs[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvs[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvs[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		prn(tvs);
		
		tvs[1].setPrice(400000);
		prn(tvs);
		
		for (Tv tv: tvs) {
			if(tv.getName().trim().equals(" CINEMA".trim())) {
				tv.setPrice(5000000);
			}
		}
		prn(tvs);
		
		
 		

		}
	
	public static void prn(Tv[] tvs) {
		System.out.println("전체 출력 ");
		for (Tv tv : tvs) {
			System.out.println(tv);
		}
	}
}
