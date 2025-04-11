package com.sec07.mytest;

public class DD extends BB{
	private int dd;

	public DD(int i,int j, int k,int l) {
		super(i,j,k);
		this.dd =l;
		
	}
	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}
	
	//부모 클래스의 getRes() 메서드를 오버라이딩
	//생성 안하고 객체에서 getRes호출하면 BB class getRes가 호출됨
	//아래처럼 오버라이딩하면 이 클래스 외 외부에선 이제 BB class 의 getRes호출 불가 
	@Override
	public int getRes() {
		//부모 클래스의 getRes() 메서드 호출 후 dd 값과 곱한 값을 반환 
		System.out.println("DD getres");
		return super.getRes() * getDd();
	}
	
	public static void main(String[]args) {
//		DD d1 = new DD();
//		d1.setA(100);
//		d1.setB(50);
//		d1.setC(5);
//		d1.setDd(2);
//		String res = String.format("( %d + %d )- %d * %d = %d \n", d1.getA(),d1.getB(),d1.getC(),d1.getDd(),d1.getRes());
//		System.out.print(res);
//		System.out.println("result : "+res);
		BB bb = new BB();
		System.out.println(bb.getA());
		System.out.println(bb.getB());
		System.out.println(bb.getC());
		System.out.println(bb.getS());
	}

}
