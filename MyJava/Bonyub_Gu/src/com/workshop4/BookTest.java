package com.workshop4;

public class BookTest {

	public static void main(String[] args) {
		
		Book[] arr = new Book[3];
		
		arr[0] = new Book("SQL PLUS", 50000, 5.0);
		arr[1] = new Book("JAVA 2.0", 40000, 3.0);
		arr[2] = new Book("JSP Servlet", 60000, 6.0);
		
		System.out.printf("%s %10s %10s %10s", "책이름", "가격", "할인율", "할인후금액");
		System.out.println();
		System.out.println("=========================================");
		
		for (int i=0; i<= 2; i++) {
			System.out.printf("%s %10d %10.1f%% %10.1f\n", arr[i].getBookName(),
					arr[i].getBookPrice(), arr[i].getBookDiscountRate()
					,arr[i].getDiscountBookPrice());
			
		}

	}

}
