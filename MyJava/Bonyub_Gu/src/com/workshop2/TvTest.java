package com.workshop2;

import java.util.Scanner;

//[문제 1]  다음과 같은 조건을 만족하는 프로그램을 작성 하시오
//3개의 TV 객체를 생성 하여 각각의 정보와 가장 비싼 제품과 가장 저렴함 제품을 출력 한다
public class TvTest {

    public static void main(String[] args) {
        
    	Scanner sc = new Scanner(System.in);

    	Tv[] tvArray = new Tv[3];

    	for(int i=1; i<=3; i++) {
    		tvArray[i-1] = new Tv();
    		System.out.println(i+"번째 TV 이름을 입력하세요");
    		tvArray[i-1].setName(sc.nextLine());
    		System.out.println(i+"번째 TV 가격을 입력하세요");
    		tvArray[i-1].setPrice(sc.nextInt());
    		sc.nextLine();
    		System.out.println(i+"번쨰 TV 종류를 입력하세요");
    		tvArray[i-1].setDesc(sc.nextLine());
    	}
    	
    	
    	
    	for (int i=0; i<=2; i++) {
        	System.out.println(tvArray[i]);
    		
    	}

    }
}


class Tv{
	
	private int Price;
	private String Name;
	private String Desc;
	
	
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	
	@Override
	public String toString() {
		return String.format("%s %10d %10s", getName(), getPrice(), getDesc());
	}
	
}



