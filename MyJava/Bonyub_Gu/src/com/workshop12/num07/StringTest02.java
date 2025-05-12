package com.workshop12.num07;

import java.util.Scanner;

public class StringTest02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 금액을 입력받음
        System.out.print("금액을 입력하세요: ");
        int money = scanner.nextInt();

        // 금액 변환 후 출력
        System.out.println(ConvertString.convert(money));

        scanner.close();
    }



}
