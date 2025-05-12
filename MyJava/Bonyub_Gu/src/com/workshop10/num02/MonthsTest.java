package com.workshop10.num02;
import java.util.Scanner;
import java.util.stream.IntStream;


public class MonthsTest {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		
		System.out.printf("월을 입력하세요(1~12):");
		int input = key.nextInt();
		
        if (IntStream.rangeClosed(1, 12).noneMatch(n -> n == input)) {
            System.out.println("입력된 값이 잘못 되었습니다.");
            return; 
        }
        
        Months month = new Months();
        
        int days = month.getDays(input);
        

        System.out.printf("입력받은 월: %d월\n", input);
        String monthType = (input % 2 == 0) ? "짝수월" : "홀수월";
        System.out.printf("짝수/홀수 여부:%s\n",monthType); // 짝수월 혹은 홀수월 출력
        System.out.printf("마지막 일자 : %d일\n", days);
        
	}

}
