package com.sec03;


/*
 * 	이름 , 세과목의 총점, 평균 구하는 클래스 만들자.
 * 			국어		수학		영어		총점		평균
 * 	홍길동	100		100		100						a1
 * 	정길동	90		90		90						b1
 * 	박길동	80		80		80						c1
 */

public class U_score {
	
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public U_score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public U_score() {
		this("noname",50,50,50);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		
		return this.getKor() + this.getEng() + this.getMat();
	}
	
	public int getAvg() {
		
		return this.getTot()/3;
	}

	
	@Override
	public String toString() {
		return String.format(
				"U_score [name=%s, kor=%s, eng=%s, mat=%s, getName()=%s, getKor()=%s, getEng()=%s, getMat()=%s, getTot()=%s, getAvg()=%s]",
				name, kor, eng, mat, getName(), getKor(), getEng(), getMat(), getTot(), getAvg());
	}

	public static void main(String[] args) {
		
		U_score a1 = new U_score();
		U_score b1 = new U_score();
		U_score c1 = new U_score();
		
		a1.setName("홍길동");
		a1.setKor(100);
		a1.setEng(100);
		a1.setMat(100);
		b1.setName("장길동");
		b1.setKor(90);
		b1.setEng(90);
		b1.setMat(90);
		c1.setName("김길동");
		c1.setKor(80);
		c1.setEng(80);
		c1.setMat(80);
		
		System.out.println(a1);
		
		//////////이름 출력, 세명의 전체 총점 구해보자.
		System.out.println("-.-.-.-..-.-.-..-.-.");
		
		System.out.printf("%10s %10s %10s \n", a1.getName(), b1.getName(), c1.getName());
		int tot = a1.getTot() + b1.getTot() + c1.getTot();
		System.out.printf("score_sum = %10d \n", tot);
		
		
		

	}

}



