package com.sec03;


/*
 * 이름, 세과목 총점, 평균을 구현하는 클래스
 * 
 * 이름 국어 영어 수학 총점 평균
 * 홍길동 100 100 100
 * 정길동 90 90 90
 * 박길동 80 80 80 
 * */
public class U_Score {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public U_Score(String name, int kor, int eng, int math) {
		//현재 Object의 super에는 아무 구현이 안되어있기 때문에 아무 작업이 이루어지지 않음
		//단 부모클래스가 있을 경우 부모클래스의 생성자가 호출됨 
		//이땐 super()의 매개변수 개수에 따라 부모클래스의 생성자 중 하나가 호출됨 
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public U_Score() {
		//내부 생성자 호출 가능
		//첫줄에 명시해야함 
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

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		return this.getKor() + this.getEng() + this.getMath();
	}
	
	public double getAvg() {
		return (double)this.getTot()/3;
	}
	

	@Override
	public String toString() {
		return String.format("%s %d %d %d %d %.2f",
				getName(), getKor(), getEng(), getMath(), getTot(), getAvg());
	}

//	public static void main(String[] args) {
//		U_Score a1 = new U_Score();
//		U_Score a2 = new U_Score();
//		U_Score a3 = new U_Score();
//		
//		a1.setName("홍길동");
//		a1.setKor(100);
//		a1.setEng(100);
//		a1.setMath(100);
//		System.out.println(a1);
//		
//		a2.setName("정길동");
//		a2.setKor(90);
//		a2.setEng(90);
//		a2.setMath(90);
//		System.out.println(a2);
//		
//		a3.setName("박길동");
//		a3.setKor(80);
//		a3.setEng(80);
//		a3.setMath(80);
//		System.out.println(a3);
//		
//		System.out.println("========================");
//		int tot = a1.getTot() + a2.getTot() + a3.getTot();
//		
//	}

}
