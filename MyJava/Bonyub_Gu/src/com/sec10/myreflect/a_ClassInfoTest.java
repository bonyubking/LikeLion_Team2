package com.sec10.myreflect;
import java.lang.reflect.Field;

//클래스 객체를 리플렉트하고 조작 실행 해보자.
class My{
	
	@SuppressWarnings("unused")
	private String name = "홍길동";

	
	@SuppressWarnings("unused")
	private int a = 10;
	
}

public class a_ClassInfoTest {

	public static void main(String[] args) throws Exception{
		
		My m1 = new My();
		Class <?> clazz = m1.getClass();
		
		Field field = clazz.getDeclaredField("name"); 
		field.setAccessible(true); // private 멤버 접근가능하게
		
		field.set(m1, "정길동");
		
		System.out.println("변경 된 값 : "+ field.get(m1));
		
		
		field = clazz.getDeclaredField("a"); 
		field.setAccessible(true); // private 멤버 접근가능하게
		
		field.set(m1, 20);
		
		System.out.println("변경 된 값 : "+ field.get(m1) );
		
		
	}

}
