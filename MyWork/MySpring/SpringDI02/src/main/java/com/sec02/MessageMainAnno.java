package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMainAnno {
	public static void main(String[] args) {
		// 프로젝트에서 리소스 path가 지정된 곳에 있는 xml파일 로드
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

		MessagePrinter res = context.getBean("AA", MessagePrinter.class);
		res.print();

		res = context.getBean("BB", MessagePrinter.class);
		res.print();

		res = context.getBean("DD", MessagePrinter.class);
		res.print();

		res = context.getBean("messagePrint02", MessagePrinter.class);
		res.print();

		Integer num = context.getBean("myResource02", Integer.class);
		System.out.println("주입된 정수 값: " + num);

	}
}
