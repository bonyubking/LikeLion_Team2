package com.sec10.myreflect;

import java.lang.reflect.Method;

//클래스를 주면 해당 어노테이션이 있는지  확인 후 해당 메소드 실행 
public class b_AnnotationInfo {

    public static void main(String[] args) {
        try {
            Class<?> clazz = b_MyClass.class; //실행했을 때 생기는 .class를 가져오는 것 
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(b_MyAnnotation.class)) {//해당 어노테이션이 있으면
                    System.out.println("어노테이션이 적용된 메서드: " + method.getName());//메소드 이름 출력 
                    method.invoke(clazz.getDeclaredConstructor().newInstance()); // 메서드 실행
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
