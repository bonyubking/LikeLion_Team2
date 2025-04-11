package com.sec10.myreflect;
//@Override  // 메서드 재정의 명시 [검색 결과 없음]
//@Deprecated  // 사용 중지 경고
//@SuppressWarnings("unchecked")  // 컴파일러 경고 무시

public class c_AnnotatinTest {

	@Override
	public String toString() {
		return "This method overrides Object.toString()";
	}

	@Deprecated
	public void oldMethod() {
		System.out.println("This method is deprecated");
	}

	@SuppressWarnings("unchecked")
	public <T> T unsafeOperation(Object obj) {
		//가변 매개인자에 대해 @SafeVarargs -> static 메소드, finald에만 사용함 
		return (T) obj; //값에 의해 타입을 결정
	}
}
