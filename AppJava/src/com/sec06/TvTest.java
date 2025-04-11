package com.sec06;

import java.util.Arrays;
import java.util.Comparator;

public class TvTest {

	public static void main(String[] args) {
		
		Tv[] tvList = {
				new Tv("INFINIA",1500000,"LED TV"),
				new Tv("XCANVAS",1000000,"LCD TV"),
				new Tv("CINEMA",2000000,"3D TV")
		};
		
		prn(tvList);
		
		System.out.println("=============================================");
		System.out.println("XCANVAS가 가진 가격을 4000000으로 변경후 전체 출력");
		tvList[1].setPrice(4000000);
		prn(tvList);
		
		System.out.println("=============================================");
		System.out.println("이름 중에 CINEAMA를 찾아 가격을 5000000으로 변경후 전체 출력");
		for(Tv tv:tvList) {
			if(tv.getName().trim().equals("CINEAM".trim())){
				tv.setPrice(5000000);
			}
		}
		prn(tvList);

	}
	
	public static void prn(Tv[] tvs) {
		System.out.println("전체 출력");
		for(Tv tv : tvs) {
			System.out.println(tv);
		}
	}

}
